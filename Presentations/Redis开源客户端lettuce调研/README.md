### 背景

仓储的项目中采用了jedis作为redis交互客户端，在一次压测时发现mget性能不佳。

spring-boot2采用了lettuce替代了jedis作为默认的redis客户端，一方面考虑的是对spring-boot2的响应式编程的支持，另一方面可能是lettuce本身的性能优于jedis。

### lettuce
lettuce在实现上有很多技术层面的理论优势。
- 基于 netty，支持事件模型
- 支持 同步、异步、响应式 的方式
- 可以方便的连接 Redis Sentinel
- 完全支持 Redis Cluster
- SSL 连接
- Streaming API
- CDI 和 Spring 的集成

#### 比较
- jedis实例是线程不安全的，多线程编程必须使用连接池管理建立好的jedis链接，然后各自获取所需要的实例。lettuce基于netty，连接实例可以在线程中间共享。


### 测试环境

#### redis cluster
- 单核：I5-8500
- 内存：4G DDR4
- 部署：单机3实例集群
- 磁盘：20G
- 网络环境：本地

#### tomcat 
- 三核：I5-8500
- 内存：4G DDR4

### 依赖版本
- lettuce:5.1.3
- jedis:2.10.0
- spring-boot:2.1.1
- jedis线程池配置同leopard项目：常活200，最大500（先不考虑这配置是否科学）
- jmeter:4.0.0
- tomcat:9.0.13

| threads | loop counts | jedis(tps) | lettuce(tps) | error(j:l) |      
| :---:|:---: | :---:  | :---: | :---:|      
| 500 | 10 | 4500 |7800| 0:0 |      
| 500 | 50 | 9400 |13054| 0:0 |     
| 500 | 100 | 9804 |14658| 0:0 |    
| 500 | 200 | 9904 |15355| 0:0 |  
| 500 | 500 | 10056 |16930 | 0:0 |  
| 1000 | 1 | 1824 |1869 | 0:0 |  
| 2000 | 1 | 2020 |2089 | 0:0 |  
| 3000 | 1 | 1655 |1711 | 0:0 |  


```javascript
- 这里以500线程数作为日常的访问量,可以发现jedis的极限TPS应该在10000左右,lettuce在17000左右
- 当并发线程增加时,jedis和lettuce的吞吐量都在2000左右
- 在set的单键操作上,lettuce对比jedis并没有明显的性能优势

```

#### get
| threads | loop counts | jedis(tps) | lettuce(tps) | error(j:l) |
| :---:|:---: | :---:  | :----: | :---:|
| 500 | 10 | 3127 |7541| 0:0 |
| 500 | 50 | 9344 |14543| 0:0 |
| 500 | 100 | 9887 |16666| 0:0 |
| 500 | 200 | 10016 |16840| 0:0 |
| 500 | 500 | 8136 |16696 | 0:0 |
| 1000 | 1 | 2277 |2159 | 0:0 |
| 2000 | 1 | 2195 |1700 | 0:0 |
| 3000 | 1 | 2089 |1710 | 0:0 |

------
- get性能同set差不多,在处理日常任务时完全够用, 500线程循环500次条件下,jedis吞吐量降低
- 在增大并发量时,jedis的吞吐量在2000左右,而lettuce在1700
------

### 多KEY操作
多key操作不进行压测，采用响应时间作为衡量标准。取5次平均值。
#### mset
| count | jedis(ms) | lettuce(ms) |
| :---: | :---:  | :---: |
| 100| 32 | 19 |
| 500 | 88| 20 |
|1000|140|17|
| 2000| 278| 32|
|5000|602|40|
|10000|1295|88|

#### mget
| count | jedis(ms) | lettuce(ms) |
| :---: | :---:  | :---: |
| 100| 10 | 16 |
| 500 | 22| 18 |
|1000|228|20|
| 2000| 640| 30|
|5000|3577|42|
|10000|11599|74|

```javascript
当key的数量较少时,使用jedis的性能会高于lettuce(mget有这种情况),不过相差在个位毫秒.当key的数量较大时,lettuce的查询性能优于jedis好几个数量级
```

### 总结
- 单键操作对于日常使用两个客户端都完全足够，lettuce的最大TPS高于jedis，而在高并发情况下，jedis略高于lettuce。
- 多键操作lettuce对于jedis有压倒性优势，在仓储环境中大量数据的操作可能更为频繁。
- 测试中使用的lettuce客户端为单实例，相比较与jedis建立了200个常活连接，节省了不少的资源开销。
- lettuce客户端同样可以使用commons-pool进行多实例拓展，性能可以进一步提升（在当前服务器瓶颈不在redis-server端时）。
- lettuce支持reactive编程，在这种模式下，理论上吞吐量会因为tomcat线程的CPU利用率提高而提高。

### 参考意见
- lettuce的使用有引进新问题的可能性。
- lettuce有替代jedis的价值。


### 改造方式
#### maven依赖

-----
        <dependency>
            <groupId>io.lettuce</groupId>
            <artifactId>lettuce-core</artifactId>
            <version>5.1.3.RELEASE</version>
        </dependency>
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
			<version>2.1.1.RELEASE</version>
		</dependency>
-----


------

考虑到很多项目没有采用spring-boot,因此这里直接引入依赖版本,若使用spring-boot,可考虑去掉version.

------

#### 添加配置类

配置项
| 键 | 说明 
| :--: | :--:  
| redis.node| redis节点IP:PORT，多个以;隔开 
| redis.password | 验证密码

-------
@Configuration
@PropertySources(
    @PropertySource({ "classpath:template-api-redis.properties", }))

public class Config {

    @Value("${redis.node}")
    String nodeURIs;

    @Value("${redis.password}")
    String password;

    @Bean
    public RedisConnectionFactory lettuceConnectionFactory() {
        String[] URIs = nodeURIs.trim().split(";");
        if (URIs.length >1){
            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
            Set<RedisNode> nodes = new HashSet<RedisNode>();
            Arrays.stream(URIs).forEach((URI) -> {
                String[] hostPort = URI.trim().split(":");
                nodes.add(new RedisNode(hostPort[0].trim(), Integer.valueOf(hostPort[1])));
            });
            redisClusterConfiguration.setPassword(RedisPassword.of(password));
            redisClusterConfiguration.setClusterNodes(nodes);

            LettuceClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder().build();
            return new LettuceConnectionFactory(redisClusterConfiguration, lettuceClientConfiguration);
        } else {
            String[] hostPort = URIs[0].trim().split(":");
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(hostPort[0],
                Integer.valueOf(hostPort[1]));
            redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

            LettuceClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder().build();
            return new LettuceConnectionFactory(redisStandaloneConfiguration, lettuceClientConfiguration);
        }
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);
        return stringRedisTemplate;
    }
    
}

-----

#### 使用说明

提供redisTemplate 和 stringRedisTemplate两个bean。
前者序列化方式默认采用json。若有其他需求可以自己配置对应的序列化方式。

#### 补充
可以使用apache commons-pool2对lettuce客户端对象进行对象池管理。

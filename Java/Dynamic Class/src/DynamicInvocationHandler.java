import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class DynamicInvocationHandler implements InvocationHandler {
    private Object target;

    public DynamicInvocationHandler(Object target) {
        this.target = target;
    }

    /** first argument is the instance of proxyInstance, so if you code a line like 'method.invoke(proxy,args)'
     * a stackoverflowerror will occur, because this function will sink in a infinite loop.
     *
     * second argument is the method you call by proxyInstance, note that when implemented two or more
     * interface while they have same method with same signature, the first one will be called.
     * (not include the java.lang.Object's method, like equals() hashCode() toString())
     *
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        if (method.getName().equals("hashCode")){
            return 41;
        }
        return method.invoke(target,args);
    }

    public static void main(String... args){
        /**
         * first argument specify a classloader to loader the proxyClass(this case a map).
         * second argument specify which class to be proxied.
         * thrid arugment specify a handler to invoke the proxied class.
         */
        Map<String,String> map = new HashMap<>();
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                String.class.getClassLoader(),
                map.getClass().getInterfaces(),
                new DynamicInvocationHandler(map));

        /**
         * InvocationHandler can also be used as a lambda .
         * But with this, you can't inject a member.
         */
//        Map proxyInstance = (Map) Proxy.newProxyInstance(
////                String.class.getClassLoader(),
////                map.getClass().getInterfaces(),
////                (proxy,method,argss)->{
////                    if (method.getName().equals("hashCode")){
////                        return 41;
////                    }
////                    return method.invoke(target,argss);
////                });


        proxyInstance.put("1","2");
        ;
        Set<Map.Entry> set = new TreeSet<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (int)o1.getValue()-(int)o2.getValue();
            }
        });
        set.iterator().next().getKey();
        System.out.println(proxyInstance.hashCode());
        System.out.println(proxyInstance.get("1"));

    }
}
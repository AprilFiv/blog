```javascript
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i =0 ;i<nums.length;i++){
            set.add(nums[i]);
        }
        for (Integer i : set){
            if (!set.contains(i-1)){
                int temp = i+1;
                while (set.contains(temp)){
                    temp++;
                }
                res = Math.max(res,temp-i);
            }
        }
        return res;
    }
}
```

also this question can be solved by unionfound.
```javascript
public class Solution {
        public int longestConsecutive(int[] nums) {
            UF uf = new UF(nums.length);
            Map<Integer,Integer> map = new HashMap<Integer,Integer>(); // <value,index>
            for(int i=0; i<nums.length; i++){
                if(map.containsKey(nums[i])){
                    continue;
                }
                map.put(nums[i],i);
                if(map.containsKey(nums[i]+1)){
                    uf.union(i,map.get(nums[i]+1));
                }
                if(map.containsKey(nums[i]-1)){
                    uf.union(i,map.get(nums[i]-1));
                }
            }
            return uf.maxUnion();
        }
    }
    
    class UF{
        private int[] list;
        public UF(int n){
            list = new int[n];
            for(int i=0; i<n; i++){
                list[i] = i;
            }
        }
        
        private int root(int i){
            while(i!=list[i]){
                list[i] = list[list[i]];
                i = list[i];
            }
            return i;
        }
        
        public boolean connected(int i, int j){
            return root(i) == root(j);
        }
        
        public void union(int p, int q){
          int i = root(p);
          int j = root(q);
          list[i] = j;
        }
        
        // returns the maxium size of union
        public int maxUnion(){ // O(n)
            int[] count = new int[list.length];
            int max = 0;
            for(int i=0; i<list.length; i++){
                count[root(i)] ++;
                max = Math.max(max, count[root(i)]);
            }
            return max;
        }
    }
```
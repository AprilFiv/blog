```javascript
class Solution {
    int res =0 ;
    int max ;
    Set<Integer> valid = new HashSet<>();
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        max = A[A.length-1];
        for (int i =0;i*i<=max+max;i++){
            valid.add(i*i);
        }
        int[] left =new int[A.length];
        for (int i = 0;i<A.length;i++){
            left[i]=A[i];
        }
        pushBack(new ArrayList<Integer>(),0,A,left);
        return res;
    }
    public void pushBack(List<Integer> list,int index,int[] A,int[] left){  
        if (list.size()==A.length){
            res++;
        }
        if (index ==0){
            Map<Integer,Integer> map = getAvailable(left);
            for (Integer i : map.keySet()){
                list.add(left[map.get(i)]);
                left[map.get(i)] =~left[map.get(i)];
                pushBack(list,index+1,A,left);
                list.remove(list.size()-1);
                left[map.get(i)]=~left[map.get(i)];
            }
        } else {
            int temp = list.get(list.size()-1);
            Map<Integer,Integer> map = getAvailable(left);
            for (Integer i : map.keySet() ){
                if (valid.contains(temp+left[map.get(i)])){
                    list.add(left[map.get(i)]);
                    left[map.get(i)] =~left[map.get(i)];
                    pushBack(list,index+1,A,left);
                    left[map.get(i)] =~left[map.get(i)];
                    list.remove(list.size()-1);
                }
            }
            
        }
    }
    
    public Map<Integer,Integer> getAvailable(int[] left){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0 ;i<left.length;i++){
            if (left[i]>=0){
                map.put(left[i],i);
            }
        }
        return map;
    }
}
```
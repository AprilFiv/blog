```javascript
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ;i<nums.length;i++){
            if (map.get(nums[i])!=null){
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }
        Set<Map.Entry> set = new TreeSet<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                if (o2.getValue()==o1.getValue()){
                    return (int)o1.getKey()-(int)o2.getKey();
                }
                return (int) o2.getValue() - (int) o1.getValue();
            }
        });
        set.addAll(map.entrySet());
        Iterator<Map.Entry> it = set.iterator();
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ;i<k;i++){
            res.add((int)it.next().getKey());
        }
        return res;
    }
}
```
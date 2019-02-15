```javascript
class Solution {
    public int majorityElement(int[] nums) {
        int judge = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i<nums.length;i++){
            if (map.get(nums[i])!=null){
                if ((map.get(nums[i])+1)>judge){
                    return nums[i];
                }
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                if (1>judge){
                    return nums[i];
                }
                map.put(nums[i],1);
            } 
        }
        return 0;
    }
}
```
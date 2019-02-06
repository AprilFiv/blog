```javascript
class Solution {
     public int[] twoSum(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;
         
        /**
        * O(n)*O(1)*O(1)
        */
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i<nums.length;i++){
            if (map.get(target-nums[i])!=null){
                start = map.get(target-nums[i]);
                end = i;
                break;
            }
            map.put(nums[i],i);
        }
        return new int[]{start,end};
    }
}
```
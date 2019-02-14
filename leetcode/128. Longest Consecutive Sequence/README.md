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
```javascript
class Solution {
    public int maxProfit(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int res = 0;
        int cur = nums[0];
        for (int i = 1 ;i<nums.length;i++){
            res = Math.max(res,nums[i]-cur);
            if (nums[i]<cur){
                cur = nums[i];
            }
        }
        return res;
    }
}
```
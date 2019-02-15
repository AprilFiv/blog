```javascript
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0]=0;
        for (int i = 0;i<nums.length;i++){
            if (i==0){
                dp[1]=nums[0];
            } else {
                dp[i+1] = Math.max(dp[i],dp[i-1]+nums[i]);
            }
        }
        return dp[nums.length];
    }
}
```
```javascript
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length+nums[nums.length-1]+1];
        dp[0] = true;
        int i = 0;
        while(dp[i]){
            for (int j= 1 ;j<=nums[i];j++){
                if (i+j>=nums.length){
                    break;
                }
                dp[i+j]=true;
            }
            i++;
            if (i==nums.length){
                break;
            }
        }
        return dp[nums.length-1];
    }
}   
```
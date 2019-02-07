```javascript
class Solution {
    
    // dp[i] = dp[i-1]+dp[i-2];
    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        int i = 3;
        while (i<=n){
            dp[i]=dp[i-1]+dp[i-2];
            i++;
        }
        return dp[n];
    }
}
```
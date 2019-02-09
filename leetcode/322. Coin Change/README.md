```javascript
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        
        for( int i=1,j=0; i<=amount; i++ )
            for( j=0,dp[i]=Integer.MAX_VALUE; j<coins.length; j++ )
                if( coins[j]<=i && dp[i-coins[j]]!=Integer.MAX_VALUE ) dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
    
   
}
```
```javascript
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int max = 0;
        for (int i = 1;;i++){
            if (i*i>n){
                break;
            } else if(i*i==n){
                return 1;
            } else {
                dp[i*i] = 1;
                max = i;
            }
        }
        for (int i =1 ;i<n+1;i++){
            if (dp[i]!=0){
                for (int j = 1 ;j<=max;j++){
                    if (i+j*j<=n){
                        int temp = dp[i+j*j]==0?Integer.MAX_VALUE:dp[i+j*j];
                        dp[i+j*j] = Math.min(dp[i]+1,temp);
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
```
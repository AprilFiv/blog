```javascript
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i =0 ;i <=word1.length();i++){
            dp[i][0]=i;
        }
        for(int j = 0 ; j<=word2.length();j++){
            dp[0][j]=j;
        }
            
        for (int i =1 ;i <=word1.length();i++){
            for(int j = 1 ; j<=word2.length();j++){
                //obviously, if word1[i]=word[j], then dp[i][j]=d[i-1][j-1];
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    //dp[i][j-1] to dp[i][j] means insert
                    //dp[i-1][j] to dp[i][j] means delete 
                    //dp[i-1][j-1] to dp[i][j] means replace;
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
```
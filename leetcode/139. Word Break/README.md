```javascript
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        for (int i = 0 ; i<wordDict.size();i++){
            if (s.startsWith(wordDict.get(i))){
                dp[wordDict.get(i).length()] = true;
            }
        }
        for (int i = 0;i<s.length();i++){
            if (dp[i]){
                for (int j = 0 ; j<wordDict.size();j++){
                    if (s.substring(i).startsWith(wordDict.get(j))){
                        dp[i+wordDict.get(j).length()] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
```
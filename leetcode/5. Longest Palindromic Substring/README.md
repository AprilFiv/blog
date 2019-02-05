```javascript
class Solution {
     public String longestPalindrome(String s) {
        if (s.length() ==0){
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int longest = 0;
        int start = 0;
        int end = 0;
        /**
        * var i is regard as the length gap between between 2d array.
        * which means j and j+i is the true index of the array.
        * dp[i][j] = dp[j+1][j+i-1] || j+i==j || j+i-j==1 if char[j]=char[j+i]
        */
        for (int i = 0 ; i<s.length();i++){
            for (int j = 0 ; j<s.length();j++){
                if(j+i<s.length()){
                if (s.charAt(j)==s.charAt(j+i)){
                    if (j==j+i || dp[j+1][j+i-1] || i==1) {
                        dp[j][j+i] = true;
                        if (i+1>longest){
                            longest = i+1;
                            start= j;
                            end = j+i;
                        }
                    }
                } else {
                    dp[j][j+i] = false;
                }
                }
            }
        }
        return s.substring(start,end+1);
    }
}
```
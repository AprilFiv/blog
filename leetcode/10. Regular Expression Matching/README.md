```javascript
class Solution {
    public boolean isMatch(String s, String p) {

        /**
         * this 2d array mains the match result of s.substring(0,i+1), p.substring(0,j+1)
         * so res[0][0] must be true, which mains they are all empty;
         */
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        res[0][0] = true;

        /**
         * this step presents the case that s is a empty string, while p can tranformed to be "empty".
         */
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && res[0][j-1]){
                res[0][j+1] = true;
            }
        }

        for (int i =0 ; i < s.length(); i++){
            for (int j = 0; j<p.length();j++){
                if (p.charAt(j) == s.charAt(i)){
                    res[i+1][j+1] = res[i][j];
                } else if (p.charAt(j) == '.'){
                    res[i+1][j+1] = res[i][j];
                } else if (p.charAt(j) == '*'){
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) !='.'){
                        res[i+1][j+1] = res[i+1][j-1];
                    } else {
                        res[i+1][j+1] = res[i][j+1] || res[i+1][j] || res[i+1][j-1];
                    }
                }
            }
        }
        return res[s.length()][p.length()];
    }
}
```
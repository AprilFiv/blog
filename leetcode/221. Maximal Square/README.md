### mine 
a half dp solution for this question.
```javascript
class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix.length==0){
            return res;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0;i<matrix.length;i++){
            dp[i][0] = matrix[i][0]-'0';
        }
        for (int i = 0;i<matrix.length;i++){
            for (int j = 1 ;j<matrix[0].length;j++){
                if (matrix[i][j]!='0'){
                    dp[i][j] = dp[i][j-1]+1;
                } else {
                    dp[i][j]=0;
                }
            }
        }
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0 ;j<matrix[0].length;j++){
                if (dp[i][j]>res){
                    res = Math.max(res,isContinued(dp,dp[i][j],i,j));
                } else {
                    
                }
            }
        }
        return res*res;
    }
    public int isContinued(int[][] dp,int length,int i ,int j){
        boolean flag = true;
        int l = Math.min(i+length,dp.length);
        int count = 1;
        int min =length;
        for (int k = i+1;k<l;k++){
            if (dp[k][j]>count && count<min){
                min = Math.min(dp[k][j],min);
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
```
### anthoer dp solution
- Copy all the values from 0th row and 0th column as it is in dp array
a. You have to calculate the max square as its possible that max exist here.
- Start iterating from i=1 and j=1
if the current value dp[i][j] = 1 and left, top, corner do not have '0' then
a. min(left, top, corner) +1
- if the current value dp[i][j] = 0 then just copy the int value of the columns
- return max*max
```javascript
     public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)  return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
    	int max = 0;
    	for(int i = 0; i<matrix.length; i++) {
    		dp[i][0] = Character.getNumericValue(matrix[i][0]);
            max = Math.max(max,dp[i][0]);
    	}
    	for(int i = 0; i<matrix[0].length; i++) {
    		dp[0][i] = Character.getNumericValue(matrix[0][i]);
            max = Math.max(max,dp[0][i]);
    	}
    	for(int i = 1; i<matrix.length; i++) {
    		for(int j = 1; j<matrix[0].length; j++) {
    			char current = matrix[i][j];
                int left = dp[i][j-1];
    			int top = dp[i-1][j];
    			int corner = dp[i-1][j-1];
                dp[i][j] = Character.getNumericValue(matrix[i][j]);
    			if(current == '1' && left != 0 && top != 0 && corner !=0) {
    					dp[i][j] = Math.min(Math.min(left,top), corner) + 1;
    			} 
    			max = Math.max(max, dp[i][j]);
    		}
    	}
		return max*max;
    }
```
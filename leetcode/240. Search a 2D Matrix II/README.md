```javascript
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = n-1,j=  0;i>=0 && j<m;){
            if (matrix[i][j]<target){
                j++;
            } else if (matrix[i][j]>target){
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
```
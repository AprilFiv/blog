A typic problem to use dynamic programming.

The top and left side of the array can calculate with a following one, 
just like a[0][i] = a[0][i]+a[0][i-1], a[i][0] = a[i][0]+a[i-1][0].
Then a element can be calculated like a[i][j] = a[i][j]+min(a[i][j-1],a[i-1][j]).

source code as follow :

```javascript
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                if (i==0 && j==0){
                    continue;
                } else if (i==0 && j>0){
                    grid[i][j] += grid[i][j-1];
                } else if (i>0 && j==0){
                    grid[i][j] += grid[i-1][j];
                } else {
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }
```
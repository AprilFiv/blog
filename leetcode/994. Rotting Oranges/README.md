```javascript
class Solution {
    int res = 0;
    public int orangesRotting(int[][] grid) {
        if (grid.length==0){
            return -1;
        }
        for (;;){
            
            boolean flag = false;
            for (int i =0 ;i<grid.length;i++){
                for (int j = 0;j<grid[0].length;j++){
                    if (grid[i][j]==2+res){
                        dfs(grid,i,j);
                        flag = true;
                    }
                }
            }
            if (!flag){
                break;
            }
            res++;
        }
        for (int i =0 ;i<grid.length;i++){
                for (int j = 0;j<grid[0].length;j++){
                    if (grid[i][j]==1){
                        return -1;
                    }
                }
        }
        if (res!=0){
            res--;
        }
        return res;
    }
    
    public void dfs(int[][] grid,int i ,int j){
        if (i-1>=0){
            if (grid[i-1][j]==1){
                grid[i-1][j] = 3+res;
            }
        }
        if (i+1<grid.length){
            if (grid[i+1][j]==1){
                grid[i+1][j] = 3+res;
            }
        }
        if (j-1>=0){
            if (grid[i][j-1]==1){
                grid[i][j-1] = 3+res;
            }
        }
        if (j+1<grid[0].length){
            if (grid[i][j+1]==1){
                grid[i][j+1] = 3+res;
            }
        }
        
    }
    
    
}
```
```javascript
class Solution {
    int res = 0;
    public int numIslands(char[][] grid) {
        if (grid.length==0){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (!visited[i][j]){
                    if (grid[i][j]=='1'){
                        res++;
                        dfs(grid,i,j,visited);
                    }
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int i ,int j,boolean[][] visited){
        
        if (!visited[i][j] && grid[i][j]=='1'){
            visited[i][j] = !visited[i][j];
        } else {
            return ;
        }
        if ( j+1<grid[0].length){
            dfs(grid,i,j+1,visited);
        } 
        if ( j-1>=0){
            dfs(grid,i,j-1,visited);
        }
        if (i-1>=0 ){
            dfs(grid,i-1,j,visited);
        }
        if (i+1  <grid.length ){
            dfs(grid,i+1,j,visited);
        }
    }
}
```
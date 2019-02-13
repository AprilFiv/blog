```javascript
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int i = 0;i<prerequisites.length;i++){
            graph[prerequisites[i][0]][prerequisites[i][1]]=true;
        }
        Set<Integer> traverd = new HashSet<>();
        for (int i = 0 ; i<numCourses  ;i++){
            if (traverd.contains(i)){
                continue;
            }
            boolean flag = false;
            //in-degree = 0
            for (int j =0 ; j<numCourses;j++){
                if (graph[j][i]){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println(i);
                traverd.add(i);
                for (int p = 0;p<numCourses;p++){
                    graph[i][p]=false;
                }
                i = -1;
            }
            
        }
        return traverd.size()==numCourses;
        
    }
}
```
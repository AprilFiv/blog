DFS
```javascript
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root,1);
    }
    public int dfs(TreeNode node,int depth){
        if (node==null){
            return depth-1;
        } else {
            return Math.max(dfs(node.left,depth+1),dfs(node.right,depth+1));
        }
    }
}
```
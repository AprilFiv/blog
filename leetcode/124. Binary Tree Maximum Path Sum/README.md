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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    
    public int dfs(TreeNode root ){
        if (root==null){return 0;}
        int left = Math.max(0, dfs(root.left)); 
        int right = Math.max(0, dfs(root.right));
        res = Math.max(res, root.val + left + right); 
        return Math.max(left, right) + root.val;
        
        
    }
    
    
}
```
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
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root,p,q);
        return res;
    }
    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root==null){
            return false;
        } 
        System.out.println(root.val);
        
        boolean cur = false;
        if (root == p || root ==q){
            cur = true;
        } 
        boolean left = find(root.left,p,q);
        boolean right = find(root.right,p,q);
        if ((cur&&left) ||(cur&&right)||(left&&right)){
            res = root;
        }
        if (left ||right || cur){
            return true;
        }
        return false;
    }
}
    

```
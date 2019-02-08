each node not only should greater than his left child and less than his right child,
he should greater or less than his parent's parent.

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
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        return validRange(root.left,Long.MIN_VALUE,root.val)&&validRange(root.right,root.val,Long.MAX_VALUE);
    }
    public boolean validRange(TreeNode node,long left,long right){
        if (node==null){
            return true;
        }
        if (node.val>left && node.val<right){
            return validRange(node.left,left,node.val)&&validRange(node.right,node.val,right);
        }
        return false;
    }
}
```
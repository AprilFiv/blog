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
    TreeNode xP ,yP;
    int xD,yD;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null){
            return false;
        }
        find(root,x,y,1);
        return xD==yD && xP!=yP;
    }
    public void find(TreeNode root, int x,int y,int d){
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left!=null){
            if (left.val ==x){
                xP = root;
                xD = d;
            }
            if (left.val == y){
                yP = root;
                yD = d;
            }
            find(root.left,x,y,d+1);  
        }
        if (right!=null){
            if (right.val ==x){
                xD = d;
                xP = root;
            }
            if (right.val == y){
                yD = d;
                yP = root;
            }
            find(root.right,x,y,d+1);  
        }
    }
}
```
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
       return isSubtree(s,t,false);
    }
    
    // thrid argument to represent if it's t's child
    public boolean isSubtree(TreeNode s, TreeNode t,boolean in) {
         if (s==null && t==null){
            return true;
        } 
        if (s==null || t==null){
            return false;
        }
        if (s.val==t.val){
            boolean left = isSubtree(s.left,t.left,true);
            boolean right = isSubtree(s.right,t.right,true);
            if (left && right){
                return true;
            } else {
                if (!in){
                    boolean another = isSubtree(s.left,t,false);
                    boolean another2 = isSubtree(s.right,t,false);
                    if (another || another2){
                        return true;
                    } 
                }
            }
        } else {
            if (!in){
            boolean another = isSubtree(s.left,t,false);
            boolean another2 = isSubtree(s.right,t,false);
            if (another || another2){
                return true;
            } else return false;
            }
        }
        return false;
    }
}
```
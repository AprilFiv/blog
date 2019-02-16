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
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root==null){
            return 0;
        }
        find(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return res;
    }
    
    public void find(TreeNode root,int sum){
        if (root==null){
            return;
        } else{
            if (root.val==sum){
                res++;
            }
            find(root.left,sum-root.val);
            find(root.right,sum-root.val);
            
        }
    }
}
```
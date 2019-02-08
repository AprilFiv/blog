Use preorder traversal the binary tree, with an index to specify the depth.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        preOrderWithIndex(root,res,1);
        return res;
    }
    public void preOrderWithIndex(TreeNode node,List<List<Integer>> res,int index){
        if (node!=null){
            while (res.size()<index){
                List<Integer> temp = new ArrayList<>();
                res.add(temp);
            }
            res.get(index-1).add(node.val);
            preOrderWithIndex(node.left,res,index+1);
            preOrderWithIndex(node.right,res,index+1);
        }
    }
}
```
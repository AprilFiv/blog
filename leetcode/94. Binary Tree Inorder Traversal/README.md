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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        } else {
          inorder(root,list);  
        }
        return list;
    }
    
    
    //inorder 
    public void inorder(TreeNode node,List<Integer> list){
        if (node.left!=null){
            inorder(node.left,list);
        }
        list.add(node.val);
        if (node.right!=null){
            inorder(node.right,list);
        }
    }
}
```
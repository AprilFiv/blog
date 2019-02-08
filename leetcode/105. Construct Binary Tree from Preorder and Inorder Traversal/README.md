
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0){
            return null;
        }
        int start = 0;
        int end = preorder.length-1;
        TreeNode root = new TreeNode(preorder[0]);
        buildTree(preorder,inorder,0,end,0,end,root);
        return root;
    }
    
    public void buildTree(int[] preorder, int[] inorder,int prestart,int preend,int instart,int inend,TreeNode parent){
        for (int i = instart ;i<=inend;i++){
            if (inorder[i]==preorder[prestart]){
                if (i!=instart){
                    TreeNode left = new TreeNode(preorder[prestart+1]);
                    parent.left= left;
                    buildTree(preorder,inorder,prestart+1,prestart+i-instart,instart,i-1,left);
                }
                if (i!=inend){
                    TreeNode right = new TreeNode(preorder[i-instart+prestart+1]);
                    parent.right = right;
                    
                    buildTree(preorder,inorder,i-instart+prestart+1,inend,i+1,inend,right);
                }
                break;
            }
        }
    }
}
```
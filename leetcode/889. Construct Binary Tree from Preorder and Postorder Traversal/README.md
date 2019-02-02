Preorder traversal can be represented as :

**(root node) (preorder of left branch) (preorder of right branch)**

Postorder traversal can be represented as :

**(postorder of left branch) (postorder of right branch) (root node)**

Thus we can find the first element with preorder in _preorder of left branch_ must the last element in _postorder of left branch_ with postorder;

And the length of left branch can be calculated.

While each child branch can be solved in such thought, 
we get the solution as follow :

```javascript
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int l = pre.length;
        if (l == 0){
            return null;
        } else if (l==1){
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);
        int judge =0;
        for (int i=0;i<post.length;i++){
            if (pre[1]==post[i]){
                judge = i+1;
            }
        }
        
        root.left = constructFromPrePost(Arrays.copyOfRange(pre,1,judge+1),Arrays.copyOfRange(post,0,l));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre,judge+1,l),Arrays.copyOfRange(post,judge,l-1));
        return root;
    }
``` 
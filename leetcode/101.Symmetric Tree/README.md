My solution is to generate two list, one is left first, and the other is right first.
judge if they are equal.
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
    public boolean isSymmetric(TreeNode root) {
        List<Integer> leftFirstInorder = new ArrayList<>();
        List<Integer> rightFirstInorder = new ArrayList<>();
        leftFirst(root,leftFirstInorder);
        rightFirst(root,rightFirstInorder);
        System.out.println(leftFirstInorder);
        System.out.println(rightFirstInorder);
        
        return leftFirstInorder.equals(rightFirstInorder);
        
    }
    public void leftFirst(TreeNode root,List<Integer> res){
        if (root!=null){
            res.add(root.val);
        
            leftFirst(root.left,res);
            leftFirst(root.right,res);
        }
        if (root==null){
            res.add(-1);
        }
    }
    public void rightFirst(TreeNode root,List<Integer> res){
        if (root!=null){
            res.add(root.val);
            
            rightFirst(root.right,res);
            rightFirst(root.left,res);
        }
        if (root==null){
            res.add(-1);
        }
    }
}
```


this solution just simplely checkevery symmetric element
```javascript
class Solution {
public boolean isSymmetric(TreeNode root) {
if(root==null) return true;
return checkSymmetric(root.left,root.right);
}
public boolean checkSymmetric(TreeNode temp1,TreeNode temp2){
if(temp1==null && temp2==null) return true;
if(temp1==null || temp2==null) return false;
if(temp1.val!=temp2.val) return false;
return ( checkSymmetric(temp1.left,temp2.right) && checkSymmetric(temp1.right,temp2.left) );
}
}
```
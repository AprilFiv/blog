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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        StringBuilder nullSb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()!=0){
            TreeNode temp = queue.poll();
            if (temp==null){
                nullSb.append("null,");
            } else {
                sb.append(nullSb.toString());
                nullSb.setLength(0);
                sb.append(temp.val+",");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        if (sb.length()==0){
            return "";
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        
        data = data.substring(1,data.length()-1);        
        
        String[] nodes = data.split(",");
        
        int i = 1 ,n = nodes.length;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.offer(root);
        while(i<n){
            if (!nodes[i].equals("null")){
                TreeNode temp = queue.peek();
                if (temp.left==null){
                    temp.left = new TreeNode(Integer.valueOf(nodes[i]));
                    queue.offer(temp.left);
                } else if (temp.right==null){
                    temp.right = new TreeNode(Integer.valueOf(nodes[i]));
                    if (temp.left.val==Integer.MIN_VALUE){
                        temp.left=null;
                    }
                    queue.poll();
                    queue.offer(temp.right);
                }
            } else {
                TreeNode temp = queue.peek();
                if (temp.left==null){
                    temp.left = new TreeNode(Integer.MIN_VALUE);
                } else if (temp.right==null){
                    if (temp.left.val==Integer.MIN_VALUE){
                        temp.left=null;
                    }
                    queue.poll();
                }
            }
            i++;
        }
        return root;
    }
    
    
    //deprecated
    public void dfs(TreeNode root,String[] nodes,int i){
         if (2*i+1<nodes.length){
             if (!nodes[2*i+1].equals("null")){
                TreeNode left = new TreeNode(Integer.valueOf(nodes[2*i+1]));
                root.left = left;   
                dfs(root.left,nodes,2*i+1);
             }
         }
         if (2*i+2<nodes.length){
             if (!nodes[2*i+2].equals("null")){
             
              TreeNode right = new TreeNode(Integer.valueOf(nodes[2*i+2]));
              root.right = right;   
              dfs(root.right,nodes,2*i+2); 
             }
         }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```
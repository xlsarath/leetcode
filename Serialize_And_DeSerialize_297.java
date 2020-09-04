
import java.util.*;



public class Serialize_And_DeSerialize_297 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == "") return null;
        String dataArr[]  = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        q.add(root);
        
        for(int i = 1; i < dataArr.length; i++){
            TreeNode parent = q.poll();
            if(!dataArr[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(dataArr[i]));
                parent.left = left;
                q.add(left);
            }
            if(!dataArr[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(dataArr[i]));
                parent.right = right;
                q.add(right);
            }
            
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
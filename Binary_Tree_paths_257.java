import java.util.*;

public class Binary_Tree_paths_257 {


    public class TreeNode{

        int val;
        TreeNode root;
        TreeNode right;
        TreeNode left;

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode right, TreeNode left){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }


    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        dfs(new StringBuilder(), root, result);
        
        return result;
    }


    private void dfs(StringBuilder sb, TreeNode root, List<String> result) {

        if(root != null){
            sb.append(""+root.val);

            if(root.left == null && root.right == null){
                result.add(sb.toString());
            } else {
                sb.append("->");
                if(root.left != null)
                    dfs(new StringBuilder(sb), root.left, result);
                if(root.left !=null)
                    dfs(new StringBuilder(sb), root.right, result);
            }
        }

    }

    public static void main(String[] args) {
        
    }

}
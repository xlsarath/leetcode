import java.util.LinkedList;
import java.util.Queue;

class MergeTwoBinaryTrees617 {

    public class TreeNode{
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int val){
             this.val = val;
         }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if(t1==null) return t2;
        if(t2==null) return t1;

        Queue<TreeNode[]> queue = new LinkedList<TreeNode[]>();

        queue.add(new TreeNode[]{t1,t2});
    
        while(!queue.isEmpty()){
            TreeNode[] root = queue.poll();
            for(int i = 0; i<queue.size();i++){

                root[0].val += root[1].val;

                if(root[0].left!=null && root[1].left!=null){
                    queue.add(new TreeNode[]{root[0].left,root[1].left});
                }

                if(root[0].right!=null && root[1].right!=null){
                    queue.add(new TreeNode[]{root[0].right,root[1].right});
                }

            }
        }
        return t1;
        // t1.val += t2.val;

        // t1.left = mergeTrees(t1.left, t2.left);
        // t2.right = mergeTrees(t1.right, t2.right);
        // return t1;
    }

    


}
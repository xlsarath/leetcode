import java.util.LinkedList;
import java.util.Queue;

public class SameTree100 {


  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
    public boolean isSameTree(TreeNode p, TreeNode q) {
      /*  
        if(p == null && q == null) return true;
        
        else if( p == null || q == null || p.val != q.val ) return false;
        
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        */
        
       Queue<TreeNode> result = new LinkedList<>();
        
        result.add(p);
        result.add(q);
         
        while(!result.isEmpty()){
            TreeNode first = result.poll();
            TreeNode second = result.poll();
            
            if(first == null && second == null)  continue;
            
            else if(first == null || second == null || first.val != second.val) return false;
            
            result.add(first.left);
            result.add(second.left);
            result.add(first.right);
            result.add(second.right);
        }    
        
        return true;
        
    }
}
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null ) return null;
        if(root.val == p.val ||  root.val == q.val) return root;
        
        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val))  
            return root;
        else if(p.val < root.val && q.val < root.val) root = root.left;
        else 
            root = root.right;
            
        return lowestCommonAncestor(root, p, q);
        
        
        /**
        if(root==null) return root;
        
        //if p,q < root
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left,p,q);
        
        
        //if p,q > root
       else if(p.val > root.val && q.val > root.val)
           return lowestCommonAncestor(root.right,p,q);
        
        //otherwise
      
        
       return root; 
        
        */
    }
}
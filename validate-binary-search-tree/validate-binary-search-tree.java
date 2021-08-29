/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time complexity : O(n)
//space complexity : O(n)
class Solution {
    //inorder and preorder.
    //inorder left,root,right
    public boolean isValidBST(TreeNode root) {
        
        return validate(root);
    }
    
    Integer prev = null;
    
    public boolean validate(TreeNode node){
        if(node==null) return true;
        
        //check left sub tree LST
        if(validate(node.left)==false) return false;
        
        if(prev!=null && node.val<=prev) return false;
        
        //then right subtree
        prev =node.val;
        return validate(node.right);
    }
    
 /**   
   private boolean validate(TreeNode node,Integer low, Integer high){
       if(node == null)
           return true;
       if((low!=null && node.val <= low) || (high!=null && node.val >= high))
           return false;
       return validate(node.left,low,node.val) && validate(node.right,node.val,high);
   }
    */    
    
}
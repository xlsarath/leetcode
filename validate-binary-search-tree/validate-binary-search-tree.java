/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null) return true;
        
       // return helper(root, null, null);
         return inorder(root);
    }
    
        
    public boolean helper(TreeNode node, Integer low, Integer high){
        
        if(node == null) return true;
        
        
        if((low != null && node.val <= low) || (high != null && node.val >= high)) return false;
        
        return helper(node.right, node.val, high) && helper(node.left, low, node.val);
        
    }
    
    Integer prev;
    public boolean inorder(TreeNode node){
        
        if(node == null) return true;
        
        if(inorder(node.left) == false)  return false;
        
        if(prev != null &&  node.val <= prev)  return false;
        
        prev = node.val;
        
        return inorder(node.right);
    } 
    
}

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
    
    int result = 0;
    
    public int maxDepth(TreeNode root) {
        
        if(root == null) return result;
        
        helper(root, 1);
        
        return  result;   
    }
    
    public void helper(TreeNode node, int n){
        
        if(node == null) return;
        
        if(result < n) result = n;
        
        helper(node.right, n+1);
        helper(node.left, n+1);
    }
}
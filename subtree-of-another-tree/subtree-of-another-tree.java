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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null) return false;
        if(isEqual(root,subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
    
    public boolean isEqual(TreeNode main, TreeNode sub){
        
        if(main == null && sub == null) return true;
        
        if(main == null || sub == null) return false;
        
        if(main.val != sub.val) return false;
        
        return isEqual(main.left, sub.left) && isEqual(main.right, sub.right);
        
    }
}
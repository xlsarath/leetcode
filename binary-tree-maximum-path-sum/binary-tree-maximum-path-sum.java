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
//time complexity : O(n)
//space complexity : O(H) -- height of tree
class Solution {
    
    Integer res;
    
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        if(root == null) return 0;
        dfs(root);
        return res;
    }
    
    
    public int dfs(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        int sum = left + right + node.val;
        res = Math.max(res, sum);
        return Math.max(left,right) + node.val;
    }
}

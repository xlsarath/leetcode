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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) return null;
        
        int rootIndex = 0;
        
        for(int i = 0 ; i < inorder.length; i++)
            if(inorder[i] ==  preorder[0]){
                rootIndex = i;
                break;
            }
        
          TreeNode root = new TreeNode(preorder[0]);
            //inorder -- Left root right
           int inorderLeft[] = Arrays.copyOfRange(inorder, 0, rootIndex);
           int inorderRight[] = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        
            //preorder -- root left right
           int preorderLeft[] = Arrays.copyOfRange(preorder, 1, 1+rootIndex);
           int preorderRight[] = Arrays.copyOfRange(preorder, 1+rootIndex, preorder.length);
        
        root.left = buildTree(preorderLeft,inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        
        return root;
        
    }
}
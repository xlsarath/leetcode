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
    
    //pre-order : Root, Left, Right
    //In-Order : Left, Root, Right
    //time complexity : O(n)
    //space complexity : O(n)
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) return null;
            
         int rootIndex = 0;
        
        for(int i = 0 ; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                rootIndex = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        
        //preorder [[3],9,20,15,7]
        //inorder [9,[3],15,20,7]
        
        int inorderLeft[] = Arrays.copyOfRange(inorder, 0, rootIndex);
        int inorderRight[] = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        
        int preorderLeft[] = Arrays.copyOfRange(preorder, 1, 1+rootIndex);
        int preorderRight[] = Arrays.copyOfRange(preorder,1+rootIndex, preorder.length);
        
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        
        return root;
    }
}
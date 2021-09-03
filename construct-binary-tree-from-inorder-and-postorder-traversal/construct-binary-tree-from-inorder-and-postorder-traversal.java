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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
       HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
    return helper(inorder, 0, postorder, 0, inorder.length, map);    
    }
    
    private TreeNode helper(int[] inorder,int i, int[] postorder, int p,int size, HashMap<Integer, Integer> map){
        
        if(size==0)
            return null;
        if(size==1)
            return new TreeNode(postorder[p]);
            
        int rootvalue = postorder[p+size-1];
        int rootindex = map.get(rootvalue);
        TreeNode root =  new TreeNode(rootvalue);
        int leftsize = rootindex-1-i+1;
        int rightsize = size - (leftsize+1);
        root.left = helper(inorder, i, postorder, p, leftsize, map);
        root.right = helper(postorder, rootindex+1, postorder, p+leftsize, rightsize, map);
        return root;
        
    }
    
}
//time complexity : n^2
//space complexity : N(logN)

import java.util.Arrays;

class ConstructBinaryTreeFromPreNInOrder105 {
    TreeNode root;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length ==0) return null;
        
        
        int rootValue = preorder[0];
        int rootIndex = 0;
        
        for(int i =0;i<inorder.length;i++){
            if(inorder[i] == rootValue){
                rootIndex = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(rootValue);
        int[] inorderleft = Arrays.copyOfRange(inorder,0,rootIndex);
        int[] inorderright = Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
        
        int[] preorderleft = Arrays.copyOfRange(preorder,1,1+rootIndex);
        int[] preorderright = Arrays.copyOfRange(preorder,1+rootIndex,preorder.length);
        
        
        root.left = buildTree(preorderleft,inorderleft);
        root.right = buildTree(preorderright,inorderright);
            
        return root;
        
        
    }

    public void inOrder(TreeNode root) 
	{ 
		if (root != null) { 
			inOrder(root.left); 
			System.out.print(root.val + " "); 
			inOrder(root.right); 
		} 
	} 
    public static void main(String[] args) {
    
        ConstructBinaryTreeFromPreNInOrder105 cb = new ConstructBinaryTreeFromPreNInOrder105();
        int [] inorderarray = {9,3,15,20,7};
        int [] preorderarray = {3,9,20,15,7};
         cb.root = cb.buildTree(preorderarray, inorderarray);
         cb.inOrder(cb.root); 





    }
}
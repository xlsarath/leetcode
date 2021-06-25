//time complexity : n^2
//space complexity : N(logN)

import java.util.*;

class ConstructBinaryTreeFromPreNInOrder105 {
    TreeNode root;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;


    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
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
         cb.root = cb.buildTree1(preorderarray, inorderarray);
         cb.inOrder(cb.root); 

    }
}
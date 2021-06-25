import java.util.Stack;

//time complexity :O(n)
//space complexity : O(K) worst case if it's skewed tree it's O(n)
//leet code : yes
//steps : recurssions by using inorder traversal.


class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    TreeNode firstNode,secondNode,previousNode;

    public void recoverTree(TreeNode root) {
        firstNode=null;secondNode =null;
        previousNode = new TreeNode(Integer.MIN_VALUE);
        
        TreeNode cursor = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while(cursor!=null){
            stack.push(cursor);
            cursor = cursor.left;
        }
        
        while(!stack.isEmpty()){
            cursor= stack.pop();
            
            
             if(firstNode==null && previousNode.val > cursor.val){
            firstNode = previousNode;
        }
        
        if(firstNode!=null && previousNode.val > cursor.val){
            secondNode = cursor;
        }
            
        previousNode =cursor;
            
        if(cursor.right!=null){
            cursor = cursor.right;
            while(cursor!=null){
                stack.push(cursor);
                cursor = cursor.left;
            }
        }
       
        }
        
        
      //  if(root==null) return;
      //  inOrder(root);
        swap(firstNode,secondNode);
    }
   /** 
    public void recoverTree(TreeNode root) {
        firstNode=null;secondNode =null;
        previousNode = new TreeNode(Integer.MIN_VALUE);
        if(root==null) return;
        inOrder(root);
        swap(firstNode,secondNode);
    }
    
    public void inOrder(TreeNode root){
        if(root==null) return;
            inOrder(root.left);
            
        if(firstNode==null && previousNode.val > root.val){
            firstNode = previousNode;
        }
        
        if(firstNode!=null && previousNode.val > root.val){
            secondNode = root;
        }
            
        previousNode =root;
            
        inOrder(root.right);
    }
*/    
    public void swap(TreeNode a,TreeNode b){
        int val = a.val;
        a.val = b.val;
        b.val = val;
    }
}
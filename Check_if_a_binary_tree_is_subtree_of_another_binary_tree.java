class TreeNode{

    TreeNode right;
    TreeNode left;
    int val;
    TreeNode(int val){
        this.val = val;
        right = left = null;
    }
}

public class Check_if_a_binary_tree_is_subtree_of_another_binary_tree {

    TreeNode t,s;

    boolean isSubTree(TreeNode t, TreeNode s){

        if(t == null && s == null) return true;

        if(t == null || s == null) return false;

        if(areIdentical(t,s)) return true;
        
        return (isSubTree(t.left, s)) || (isSubTree(t.right, s));

    }

    private boolean areIdentical(TreeNode t, TreeNode s) {

            if(t == null && s == null) return true;

            if(t == null || s == null) return false;

            return t.val == s.val && areIdentical(t.left, s.left) && areIdentical(t.right, s.right);


    }

    public static void main(String[] args) {
        Check_if_a_binary_tree_is_subtree_of_another_binary_tree tree = new Check_if_a_binary_tree_is_subtree_of_another_binary_tree(); 
           
        // TREE 1 
        /* Construct the following tree 
              26 
             /   \ 
            10     3 
           /    \     \ 
          4      6      3 
           \ 
            30  */
            
        tree.t = new TreeNode(26); 
        tree.t.right = new TreeNode(3); 
        tree.t.right.right = new TreeNode(3); 
        tree.t.left = new TreeNode(10); 
        tree.t.left.left = new TreeNode(4); 
        tree.t.left.left.right = new TreeNode(30); 
        tree.t.left.right = new TreeNode(6); 
   
        // TREE 2 
        /* Construct the following tree 
           10 
         /    \ 
         4      6 
          \ 
          30  */
            
        tree.s = new TreeNode(10); 
        tree.s.right = new TreeNode(6); 
        tree.s.left = new TreeNode(4); 
        tree.s.left.right = new TreeNode(30); 
   
        if (tree.isSubTree(tree.t, tree.s)) 
            System.out.println("Tree 2 is subtree of Tree 1 "); 
        else
            System.out.println("Tree 2 is not a subtree of Tree 1"); 
    }


}
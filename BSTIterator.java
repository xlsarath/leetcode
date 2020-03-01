//time complexity : almost O(n)
//space complexity : O(h) h is height of tree
//leet code execution : suceessfull
//steps : have considered a stack and pushed all the left nodes of tree onto stack. while retriving poping left node on element and pushing all of it's right nodes. for hasnext verify is stack is empty or not. if it's not empty there are elements in tree.

import java.util.Stack;

class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        st = new Stack<>();        
        TreeNode node =root;
        dfs(node);
    }
    
    private void dfs(TreeNode node){
        while(node!=null){
            st.push(node);
            node = node.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        dfs(node.right);
        return node.val;
        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
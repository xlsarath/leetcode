class Solution {
    public boolean verifyPreorder(int[] preorder) {
        
       Stack<Integer> stack = new Stack<>();
       Stack<Integer> inorder = new Stack<>();
        
       for(int val : preorder){
           
           if(!inorder.isEmpty() && val < inorder.peek()) return false;
           
           while(!stack.isEmpty() && val > stack.peek())
               inorder.push(stack.pop());
           stack.push(val);
       } 
        return true; 
    }
}


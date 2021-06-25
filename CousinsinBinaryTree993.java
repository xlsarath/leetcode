//time complexity : O(n);
//space complexity : O(n);
//leetcode : yes
// steps: use BFS and traverse through tree. if parent of X not euqal to parent Y and level of x is equal to level of y return true.
// DFS is also implemented

class CousinsinBinaryTree993 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
   
    
    TreeNode parentX=null, parentY = null;
       int levelX = -1,levelY =-1,level=0;
   
   public boolean isCousins(TreeNode root, int x, int y) {
       
       if(root==null) return false;
   
       if(root.val==x||root.val==y) return false;
       
       dfs(root,x,y,0);
       
         if(parentX!=null && parentY!=null && parentX!=parentY && levelX ==levelY){
                   return true;
         }
       return false;
   }
     /**  
       TreeNode parentX=null, parentY = null;
       int levelX = -1,levelY =-1,level=0;
       
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       
       while(!queue.isEmpty()){
               int countNodes = queue.size();
           for(int i=0; i<countNodes;i++){
           TreeNode currentNode = queue.poll();

               
               if(currentNode.left!=null){
                   if(currentNode.left.val==x){
                       parentX = currentNode;
                       levelX = level;
                   }
                  else if(currentNode.left.val==y){
                       parentY = currentNode;
                       levelY = level;
                   }
                   queue.add(currentNode.left);
               }
               
               if(currentNode.right!=null){
                   if(currentNode.right.val==x){
                       parentX = currentNode;
                       levelX = level;
                   }
                   else if(currentNode.right.val==y){
                       parentY = currentNode;
                       levelY = level;
                   }
                   queue.add(currentNode.right);
               }
               
               if(parentX!=parentY && levelX ==levelY){
                   return true;
               }
           }
           level++;
           
       }
       return false;
       
   }
   */
   
       public void dfs(TreeNode currentNode, int x, int y, int level) {
           
           if(currentNode==null) return;
           
           if(currentNode.left!=null){
                   if(currentNode.left.val==x){
                       parentX = currentNode;
                       levelX = level;
                   }
                  else if(currentNode.left.val==y){
                       parentY = currentNode;
                       levelY = level;
                   }
           dfs(currentNode.left,x,y,level+1);    
           }
            if(currentNode.right!=null){
                   if(currentNode.right.val==x){
                       parentX = currentNode;
                       levelX = level;
                   }
                   else if(currentNode.right.val==y){
                       parentY = currentNode;
                       levelY = level;
                   }
           dfs(currentNode.right,x,y,level+1);    
               }
           
       }

   
}
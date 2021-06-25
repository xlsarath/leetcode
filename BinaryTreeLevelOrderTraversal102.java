import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//time complexity :  O(n)
//space complexity:  O(n)
//leet code : yes
//steps: first add rootnode into queue. then add it's corresponding childs after polling parent from queue. like wise for every level until the last leadf nodes reached. by crossing each level ensure to mark your level, here new linkedlist for everylevel gets  created. this was done wiht help of curent level queue size.
class BinaryTreeLevelOrderTraversal102 {


    
     public class TreeNode {
        int val;
        TreeNode left;
     TreeNode right;
     TreeNode(int x) {
          val = x; 
        }
    }
     


public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    if(root==null) return null;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        int countNodes = queue.size();
        List<Integer> currentLevel = new LinkedList<>();
        for(int i=0; i< countNodes;i++){
            TreeNode current = queue.poll();
            currentLevel.add(current.val);

            if(current.left!=null){
                queue.add(current.left);
            }

            if(current.right!=null){
                queue.add(current.right);
            }
        }
    result.add(currentLevel);

    }
    return result;

}


}
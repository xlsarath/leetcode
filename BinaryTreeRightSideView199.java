import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Time complexity : O(n)
//Space compexity : O(n)
//Leet code : yes
//Steps: use BFS. in the while loop just add the elements that exist on the last/right edge of queue and return the list after the loop exhausts.
class BinaryTreeRightSideView199 {

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}

public List<Integer> rightSideView(TreeNode root) {

    List<Integer> result = new LinkedList<>();
    if(root==null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){

        int countNodes = queue.size();
        for(int i=0;i<countNodes;i++){
            TreeNode current = queue.poll();
            if(i==countNodes-1){
                result.add(current.val);
            }
            if(current.left!=null) queue.add(current.left);
            if(current.right!=null) queue.add(current.right);
        }
    }
return result;

}

}
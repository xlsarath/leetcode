import java.util.*;

//N array Tree :  
/**
 *              1 -- root
 *            / |   \
 *         2    3    4
 *       / | \  |   / | \
 *      5  6  7 8  9  10  11
 */


public class NArrayTree {



class TreeNode{

    int val;
    List<TreeNode> children; 

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(List<TreeNode> children){
        this.children = children;
    }
}

TreeNode root;

NarrayTree(){
    root = new TreeNode(1);
}

public static void printNArrayTree(TreeNode root){

    if(root == null) return;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(!q.isEmpty()){
        int size = q.size();

        for(int i = 0 ; i < size; i++){
            TreeNode temp = q.poll();
            System.out.print(temp.val+" ");
            for(TreeNode node : temp){
                q.offer(node);
            }
        }
        System.out.println();
    }
}

    
}

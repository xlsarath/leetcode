import java.util.HashMap;
//time complexity : N+N (one n for hashmap, the other one is for recursion)
//space complexity : O(n)
//leet code execution : successfull
//steps : iterate over inorder/postorder array and add all values into map with their respective indexes, one done fetch the rootvalue and rootindex. rootvalue will be lastval of postorder array . using this element root index can be fetched from map. now circum navigate on calulated rootindex on every recursion call by using sixe - e+1.

class ConstructBinaryTreeINorderNPostOrder106 {

     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public TreeNode buildTree(int[] inorder, int[] postorder){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(inorder,0,postorder,0,inorder.length,map);

    }
   //       L root R
   //in     9,3,15,20,7
   //post   9,15,7,20,3
    //      L R root
    private TreeNode helper(int[] inorder, int i, int[] postorder, int p, int size, HashMap<Integer,Integer> map ){

        if(size==0) return null;

        if(size==1) return new TreeNode(postorder[p]);

        int rootValue = postorder[p+size-1];
        int rootIndex = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        int leftSize = rootIndex-1-i+1;
        int rightSize = size-(leftSize+1);
        root.left = helper(inorder, i, postorder, p, size, map);
        root.right = helper(inorder, rootIndex+1, postorder, p+leftSize, rightSize, map);
        return root;



    }



}
import java.util.ArrayList;

class BinaryTreeImplementation {

    public TreeNode root = null;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        left=null;
        right = null;
    }
}

    public BinaryTreeImplementation(ArrayList<Integer> arr) {
        root = new TreeNode(arr.get(0));
        for(int i = 1; i<arr.size();i++){
            int element = arr.get(i);
            TreeNode val = null;
            TreeNode currVal = root;

            while(currVal!=null){
                val = currVal;
                currVal = element<currVal.val ? currVal.left : currVal.right;
                if(element<val.val){
                    val.left = new TreeNode(element);
                }
                else {
                    val.right = new TreeNode(element);
                }
            }
        }
    }

    public void treeTraversal(TreeNode node){
            if(node==null) return;
            treeTraversal(node.left);
            System.out.println(node.val);
            treeTraversal(node.right);


    }

  






public static void main(String[] args) {

    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(2);
    arr.add(3);
    arr.add(1);
    BinaryTreeImplementation bt = new BinaryTreeImplementation(arr);
    bt.treeTraversal(bt.root);
        
}

}
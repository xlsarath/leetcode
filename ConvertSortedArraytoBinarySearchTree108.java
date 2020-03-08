class ConvertSortedArraytoBinarySearchTree108{

    public class TreeNode{

        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }

    int nums[];
    public TreeNode sortedArrayToBST(int[] nums) {
    this.nums = nums;
    return helper(0,nums.length-1);

    }

    private TreeNode helper(int left, int right) {
        
        if(left>right) return null;
        int mid = (left+right)/2;

        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = helper(left, mid-1);
        root.right = helper(mid+1, right);
        
        return root;
    }

}
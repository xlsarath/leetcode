//time complexity : O(n)
//space complexity : O(n)
//leet code execution : successful
//steps :  initialised a global variable result to track sum, to calculate running sum at every node used following (runningsum * 10 + node.val) math. once recursion reches leaf node.then runningsum is added to result and resturned.

class SumRootToLeafNumber129 {

    public class TreeNode {
         int val;
         TreeNode left;
        TreeNode right;
         TreeNode(int x) { val = x; }}
        Integer result;
         public int sumNumbers(TreeNode root) {
            result = 0;
            if(root==null) return result;
         helper(root,0);
         return result;
        
        }
		private void helper(TreeNode root, int i) {
            if(root.left==null && root.right==null){
                result += i*10+root.val;
                return;
            }

            i = i*10+root.val;
            if(root.left!=null){
                helper(root.left, i);
            }

            if(root.right!=null){
                helper(root.right, i);
            }
            

    }
}
        



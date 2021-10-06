/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> l = new ArrayList<>();
        HashSet<TreeNode> set = new HashSet<>();
        
        dfs(root, p, l);
        for(TreeNode element : l){
            set.add(element);
        }
        
        l.clear();
        dfs(root, q, l);
        for(int i = l.size()-1 ; i  >= 0 ; i--){
        if(set.contains(l.get(i)))
            return l.get(i);
        }
        
        return null;
    }
    
    public boolean dfs(TreeNode root, TreeNode node, List<TreeNode> list){
        
        if(root == null) return false;
        if(root == node) {
            list.add(node);
            return true;
        }
        
        list.add(root);

        if(dfs(root.left, node, list))
            return true;
        
        if(dfs(root.right, node, list))
            return true;
        
        list.remove(list.size()-1);
        return false;
    }
}
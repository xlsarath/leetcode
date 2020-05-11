class PopulatingNextRightPointersinEachNode116{
//time complexity : O(n)
//space complexity : O(n)
//leet code : yes
//steps : always point curosr towards the right edge and point right edge node to left edge.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
  public Node connect(Node root) {
        if(root==null) return root;
        
        Node firstNodeLevel = root;
        
        while(firstNodeLevel.left != null){
            Node cursor = firstNodeLevel;
            
            while(cursor!=null){
                cursor.left.next = cursor.right;
                if(cursor.next!=null){
                    cursor.right.next = cursor.next.left;
                }
                cursor = cursor.next;
            }
            firstNodeLevel =  firstNodeLevel.left;
        }
        return root;
    }

    /**
     * public Node connect(Node node) {
        if(node == null) return node;
        
        if(node.left!=null){
            node.left.next = node.right;
            if(node.next!=null){
                node.right.next = node.next.left;
            }
        }
        connect(node.left);
        connect(node.right);
        return node; 
    }
     */

}
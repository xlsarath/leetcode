/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    HashMap<Integer,Node> store = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Node clone =  new Node(node.val);
        store.put(node.val,clone);
        dfs(node);
        return clone;
    }
    
    
    public void dfs(Node node){
        
        Node currentClone = store.get(node.val);
        
        for(Node neighbor : node.neighbors){
            Node currentNeighborClone = store.get(neighbor.val);
            if(currentNeighborClone == null){
                currentNeighborClone = new Node(neighbor.val);
                store.put(neighbor.val, currentNeighborClone);
                dfs(neighbor);
            }
            currentClone.neighbors.add(currentNeighborClone);
        }
        
        
    }
}
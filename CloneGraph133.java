import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//time complexity :O(V+E) v is vertices and E is edges of graph
//space complexity : O(V+E)
//leet code : yes
//steps : BFS 
public class CloneGraph133 {


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

Map<Integer,Node> store = new HashMap<>();

//DFS
public Node cloneGraph(Node node) {
        
    if(node == null ) return null;
    
    
    Node cloneNode = new Node(node.val);
    store.put(node.val,cloneNode);
    dfs(node);
return cloneNode;
}
private void dfs(Node current){
        Node clonecurrent = store.get(current.val);
        
        for(Node neighbor : current.neighbors){
            Node cloneNeighbor = store.get(neighbor.val);
            if(cloneNeighbor==null){
                cloneNeighbor = new Node(neighbor.val);
                store.put(neighbor.val,cloneNeighbor);
                dfs(neighbor);
            }
            
            clonecurrent.neighbors.add(cloneNeighbor);
        }
    }
}
//BFS --- 
    // public Node cloneGraph(Node node) {
        
    //     if(node == null ) return null;
        
    //     Map<Integer,Node> store = new HashMap<>();
    //     Queue<Node> queue = new LinkedList<>();
        
    //     Node cloneNode = new Node(node.val);
    //     store.put(node.val,cloneNode);
    //     queue.offer(node);
        
    //     while(!queue.isEmpty()){
    //         Node current = queue.poll();
    //         Node clonecurrent = store.get(current.val);
            
    //         for(Node neighbor : current.neighbors){
    //             Node cloneNeighbor = store.get(neighbor.val);
    //             if(cloneNeighbor==null){
    //                 cloneNeighbor = new Node(neighbor.val);
    //                 store.put(neighbor.val,cloneNeighbor);
    //                 queue.add(neighbor);
    //             }
                
    //             clonecurrent.neighbors.add(cloneNeighbor);
    //         }
    //     }
    //     return cloneNode;
    // }
}
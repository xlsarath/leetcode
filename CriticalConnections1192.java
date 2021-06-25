import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class CriticalCOnnection1192 {
    
    
        int time;
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            
            
            List<List<Integer>> result = new LinkedList<>();
            
            //base case
            if(connections.size() == 0 || n == 0 || connections == null) return result;
            
            //init graph
            List<Integer>[] adjacencyList = createGraph(n, connections, false);
            
            //book-keeping
            boolean[] visited = new boolean[n];
            int[] discoveryTime = new int[n];
            int[] lowTime = new int[n];
            int[] parent = new int[n];
            time =0;
            
            //call dfsVisit for unvisited nodes
            for(int u = 0 ; u < n; u++){
              // if(!visited[u])
                    dfs(adjacencyList, u , visited, discoveryTime, lowTime, parent, result);
            }
            
            return result;
            
        }
        
        public List<Integer>[] createGraph(int n, List<List<Integer>> edges, boolean printGraph){
        List<Integer>[] adjacencyList = new LinkedList[n];
            
            // create graph with just the vertices
            for(int i = 0 ; i < n ; i++){
                adjacencyList[i] = new LinkedList<>();
            }
            
            //add edges
            for(List<Integer> edge : edges){
                int u = edge.get(0);
                int v = edge.get(1);
                adjacencyList[u].add(v);
                adjacencyList[v].add(u);
            }
            //print graph
            if(printGraph){
                for(int i = 0 ; i < n; i ++){
                    System.out.println(i +" : "+ adjacencyList[i]);
                }
            }
            return adjacencyList;
            
        }
        
        
        public void dfs(List<Integer>[] adjacencyList, int u, boolean[] visited, int[] discoveryTime, int[] lowTime, int[] parent, List<List<Integer>> result){
            // mark visited
            visited[u] = true;
            
            // update time
            time++;
            discoveryTime[u] = time;
            lowTime[u] = time;
            //iterate on neighbours
            for(int v : adjacencyList[u]){
                if(!visited[v]){
                    parent[v] = u;
                    dfs(adjacencyList, v, visited, discoveryTime, lowTime, parent, result);
                    lowTime[u] = Math.min(lowTime[u],lowTime[v]);
                    if(lowTime[v] > discoveryTime[u]) { // bridge detected
            List<Integer> edge = new LinkedList<>();
            edge.add(u);
                        edge.add(v);
                        result.add(edge);
                    }
                } else if( v != parent[u]){
                    lowTime[u] = Math.min(lowTime[u], discoveryTime[v]);
                } 
            }
            
            
        }
    
public static void main(String[] args) {
    List<List<Integer>> ls = new   ArrayList<List<Integer>>();
    List<Integer> l1 = new ArrayList<>();
    l1.add(0); l1.add(1);List<Integer> l2 = new ArrayList<>();
    l2.add(1); l2.add(2);List<Integer> l3 = new ArrayList<>();
    l3.add(2); l3.add(0);List<Integer> l4 = new ArrayList<>();
    l4.add(1); l4.add(3);ls.add(l1);ls.add(l2);ls.add(l3);ls.add(l4);
    System.out.println(new CriticalCOnnection1192().criticalConnections(4, ls ));
}

}
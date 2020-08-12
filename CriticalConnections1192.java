import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class CriticalCOnnection1192 {

    int time = 0;
    List<List<Integer>> criticalConnections;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    
        criticalConnections = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(connections, n, graph);

        int [] discover = new int[n];
        Arrays.fill(discover, -1);
        int [] lowest = new int[n];

        dfs(graph, 0 , 0, discover, lowest);

        return criticalConnections;
    }
        
    private void dfs(HashMap<Integer, List<Integer>> graph, int current, int parent, int[] discover, int[] lowest) {

        //base 
        if( discover[current] != -1) return;

        discover[current] = time;
        lowest[current] = time;
        time++;

        for(Integer neighbor : graph.get(current)){
            if(neighbor == parent){
                continue;
            }
            dfs(graph, neighbor, current, discover, lowest);
            
            if(lowest[neighbor] > discover[current]) 
                criticalConnections.add(Arrays.asList(current,neighbor));
            lowest[current] = Math.min(lowest[current],lowest[neighbor]);
        
            }
        return;


    }

    // [[0,1],[1,2],[2,0],[1,3]]
    private void buildGraph(List<List<Integer>> connections, int n, HashMap<Integer, List<Integer>> graph) {

        for (int i = 0; i < n ; i++){
            graph.put(i, new ArrayList<>());
        }

        for(List<Integer> edge : connections){
            int from = edge.get(0);
            int to = edge.get(1);

            graph.get(from).add(to);
            graph.get(to).add(from);

            // 0 -- 1,2
            // 1 -- 0,2,3
            // 2 -- 0,1
            // 3 -- 1  
        }
        return;

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
import java.util.*;
//time complexity : O(n + m) m is length of connection
//space : O(n);
public class Number_of_Operations_to_Make_Network_Connected_1319 {


    public  static int makeConnected(int n, int[][] connections) {

            if(connections.length < n-1) return -1;

            List<Integer>[] adjGraph = getAdjGraph(n, connections);

            int componenets = 0;
            boolean visited[] = new boolean[n];

            for(int v = 0 ; v < n; v++) componenets += dfs(v, adjGraph, visited);

            return componenets - 1;
    }

    private  static int dfs(int u, List<Integer>[] adjGraph, boolean[] visited) {
        if(visited[u]) return 0;
        visited[u] = true;
        for(int v : adjGraph[u]) dfs(v, adjGraph, visited);
        return 1;
    }

    private static List<Integer>[] getAdjGraph(int n, int[][] connections) {
        List<Integer>[] adjGraph = new LinkedList[n];

        for(int u = 0; u < n ; u++){
            adjGraph[u] = new LinkedList<>();
        }

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            adjGraph[u].add(v);
            adjGraph[v].add(u);
        }

        return  adjGraph;
    }

public static void main(String[] args) {
   
    System.out.println(Number_of_Operations_to_Make_Network_Connected_1319.makeConnected(4, new int[][]{{0,1},{0,2},{1,2}}));
    
}

}

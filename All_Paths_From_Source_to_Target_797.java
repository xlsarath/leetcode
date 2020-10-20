import java.util.*;
 //time complexity : 2 ^ n
 //space complexity : O(n)
 

public class All_Paths_From_Source_to_Target_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> state = new ArrayList<>();

        state.add(0);

        dfs(graph, 0, state, result);

        return result;
    }

    private void dfs(int[][] graph, int index, List<Integer> state, List<List<Integer>> result) {

        if(index == graph.length){
            result.add(new ArrayList<>(state));
            return;
        }

        for(int eachGrid : graph[index]){
            state.add(eachGrid);
            dfs(graph, eachGrid, state, result);
            state.remove(state.size()-1);
        }

    }

}
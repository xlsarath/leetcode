class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        state.add(0);
        backTracking(graph, result, state, 0);
        
        return result;
    }
    
    public void backTracking(int[][] graph, List<List<Integer>> result, List<Integer> state,  int idx){
        
        //base
        if(idx == graph.length - 1){
            result.add(new ArrayList<>(state));
            return;
        }
        
        
        for(int val : graph[idx]){
            state.add(val);
            backTracking(graph, result, state, val);
            state.remove(state.size()-1);
        }
        
    }
}
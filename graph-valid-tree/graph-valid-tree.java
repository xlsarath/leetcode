class Solution {
    
    
    
    public boolean validTree(int n, int[][] edges) {
        
        HashSet<Integer> seen = new HashSet<>();
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        if(edges.length != n - 1) return false;
        
        
        for(int i = 0; i < n; i++)
            adjacencyList.add(new ArrayList<>());
        
        for(int edge[]: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        dfs(0, seen, adjacencyList);
        
        return seen.size() == n;
    }
    
    public void dfs(int node,  HashSet<Integer> seen,  List<List<Integer>> adjacencyList){
        if(seen.contains(node)) return;
        seen.add(node);
        for(int neighbor : adjacencyList.get(node))
            dfs(neighbor,seen,adjacencyList);
    }
    
    
}
//time complexity :  O(V + E)
//space compelxity : O(V + E)

class Solution {
    public int countComponents(int n, int[][] edges) {
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0 ; i < n; i++)
            adjacencyList.add(new ArrayList<>());
        
        for(int edge[] : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        
        int []visited = new int[n];
        int count = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0) {
                count++;
            dfs(visited, adjacencyList,i);
            }
        } 
        return count;
    }
    
    public void dfs(int[] visited, List<List<Integer>> adjacencyList, int i){
        
        visited[i] = 1;
        
        for(int k = 0; k < adjacencyList.get(i).size(); k++){
            if(visited[adjacencyList.get(i).get(k)] == 0){
                dfs(visited,adjacencyList, adjacencyList.get(i).get(k));
            }
        }
        
    }
}
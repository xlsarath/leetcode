//time complexity :  
    //        this if for Iterative DFS approach : O(V + E)
    // for UnionFInd/ Disjoint sets  : O(V + E*α(n)).
//space compelxity DFS : O(V + E)
// space complexity unionFInd : O(V)

class Solution {
    
        public int find(int parent[], int x){
            
            if(x == parent[x])
                return x;
            return parent[x] = find(parent, parent[x]);
            
        }
    
    
        public int unionFind(int parent[], int x, int y, int rank[]){
            
            int rootX = find(parent, x);
            int rootY = find(parent, y);
            
            if(rootX == rootY) return 0;
            else {
                if(rank[rootX] > rank[rootY]){
                    rank[rootX] += rank[rootY];
                    parent[rootY] = rootX;
                } else {
                    rank[rootY] += rank[rootX];
                    parent[rootX] = rootY;
                }
                return 1;
            }
        }
    
        public int countComponents(int n, int[][] edges) {
            
            int parent[] = new int[n];
            int rank[] = new int[n];
            
            for(int i = 0 ; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
            
            int count = n;
            for(int i = 0 ; i < edges.length ; i++){
                count -= unionFind(parent, edges[i][0], edges[i][1], rank);
            }
                
        return count;
        }
    
    /**
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
    */
}

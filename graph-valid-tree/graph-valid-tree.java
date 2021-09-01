/**
 time complexity : 
        Iterative DFS : N + E (Nodes + Edges)
        BFS : N + E
        UnionFInd : O(N⋅α(N)) -- α(N) is Inverse Ackermann Function.
        
Space complexity for all algos: O(N)       

*/

class UnionFind {
    
    private int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
                         // a standalone vertex with no connection to other vertices.
        }
    }
    
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }
    
    
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY) return false;
        
        if(rank[rootX] < rank[rootY]){
            root[rootX] = rootY;
            rank[rootY] += rank[rootX];
        } else {
            root[rootY] = rootX;
            rank[rootX] += rank[rootY];
        }
        return true;
    }
    
}
class Solution {
    
    
        public boolean validTree(int n, int[][] edges) {
                
            if(edges.length != n - 1) return false;
            
            UnionFind unionFind = new UnionFind(n);
               
            
            for(int edge[] : edges ){
                
                int A = edge[0];
                int B = edge[1];
                if(!unionFind.union(A,B))
                    return false;
            }
            return true;
        }
    
  
    /**
    
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
        
        // dfs(0, seen, adjacencyList);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        seen.add(0);
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            for(int neighbor : adjacencyList.get(node)){
                if(seen.contains(neighbor)) continue;
                q.offer(neighbor);
                seen.add(neighbor);
            }
            
        }
        
        
        return seen.size() == n;
    }
    
    public void dfs(int node,  HashSet<Integer> seen,  List<List<Integer>> adjacencyList){
        if(seen.contains(node)) return;
        seen.add(node);
        for(int neighbor : adjacencyList.get(node))
            dfs(neighbor,seen,adjacencyList);
    }
    
    */
    
}

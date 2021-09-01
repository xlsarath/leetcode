// time complexity : UnionFind : O(v + E*a(n)); // sorting nlogn  --- nlogn
//space comeplxity : O(n)
class UnionFind{
    
    int parent[];
    int rank[];
    
    public UnionFind(int size){
        parent = new int[size];
        rank = new int[size];
        
        for(int i = 0 ; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
    
    public boolean union(int x, int y){
        
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY) return false;
        
        if(rank[rootX] > rank[rootY]){
            rank[rootX] += rank[rootY];
            parent[rootY] = rootX;
        } else {
            rank[rootY] += rank[rootX];
            parent[rootX] = rootY;
        }
        
        return true;
    }
    
}

class Solution {
    
    
    
    public int earliestAcq(int[][] logs, int n) {
        
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
        
        UnionFind uf = new UnionFind(n);
        
        for(int[] log: logs ){
            
            if(uf.union(log[1], log[2])){
                n--;
            }
            
            if(n == 1) return log[0];
        }
        return -1;
    }
}
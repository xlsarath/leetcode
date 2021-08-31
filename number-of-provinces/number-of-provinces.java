class Solution {
    
        public int find(int parent[], int i){
            if(parent[i] == -1)
                return i;
            return find(parent, parent[i]);
        }
    
    
        public void union(int parent[], int x, int y){
                
            int rootx = find(parent,x);
            int rooty = find(parent,y);
            
            if(rootx != rooty)
                parent[rootx] = rooty;
        }
    
    
       public int findCircleNum(int[][] isConnected) {
       
           int parent[] = new int[isConnected.length];
           Arrays.fill(parent, -1);
           for(int i = 0 ; i < isConnected.length; i++){
               for(int j = 0 ; j < isConnected.length; j++){
                   if(isConnected[i][j] == 1 && i!=j)
                       union(parent, i , j);
               }
           }
           
           int provinceCount = 0;
           for(int i = 0 ; i < isConnected.length; i++)
                if(parent[i] == -1) provinceCount++;
           
          return provinceCount; 
       }
    
   
}

/**

DFS :: 

time complexity : O(n^2)
space complexity : O(n)

    public int findCircleNum(int[][] isConnected) {
        
        int numOfProvinces = 0;
        boolean isVisited[] = new boolean[isConnected.length];
        
        for(int i = 0; i < isConnected.length; i++){
        
                if(!isVisited[i]){ 
                    dfsVisit(isConnected, i, isVisited);
                    numOfProvinces++;
                }
            
        }
        return numOfProvinces;
    }
    
    
    private void dfsVisit(int[][] isConnected, int row, boolean isVisited[]){
        
        isVisited[row] = true;
        
        for(int i = 0 ; i < isConnected.length; i++){
            
            if(isConnected[row][i] == 1 && !isVisited[i]){
                dfsVisit(isConnected, i, isVisited);
            }
            
        }
        
    }
    

*/

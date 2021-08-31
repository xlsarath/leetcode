class Solution {
    
   
    
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
    
   
}
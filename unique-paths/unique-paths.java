class Solution {
    public int uniquePaths(int m, int n) {
       
        int distinctPaths[][] = new int[m][n];
        
        for(int col = 0 ; col < n; col++) 
            distinctPaths[0][col] = 1;
        
        for(int row = 1; row < m; row++)
            distinctPaths[row][0] = 1;
        
        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                distinctPaths[row][col] = distinctPaths[row -1][col] + distinctPaths[row][col -1];
            }
        }
        
        return distinctPaths[m-1][n-1];
    }
}
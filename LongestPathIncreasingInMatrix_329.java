//time complexity : O(m * n) if it's nxn matrix : O(n^2)
//space complexity : O(n ^ 2)
public class LongestPathIncreasingInMatrix_329 {

    
        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};
        
        public int longestIncreasingPath(int[][] matrix) {
            
            
            int row = matrix.length;
            int col = matrix[0].length;
            
            int[][] cache = new int[row][col];
            int max = 1;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    
                    int len = dfsVisit(matrix, i, j, cache );
                    max = Math.max(max,len);
                }
            }
          //  System.out.println(Arrays.deepToString(cache));
            return max;
        }
        
        public int dfsVisit(int matrix[][], int i, int j, int[][] cache){
            
            if(cache[i][j] != 0) return cache[i][j];
            int max = 1;
            for(int k = 0 ; k < 4; k++){
                
                int x = i + dx[k];
                int y = j + dy[k];
                
                if( isValid(matrix, x, y) && matrix[x][y] > matrix[i][j])  {
                    int len = 1+ dfsVisit(matrix, x, y, cache);
                    max = Math.max(max,len); 
                                                                            }
                
            }
            
            cache[i][j] = max;
            return max;
        }
        
        public boolean isValid(int[][] matrix, int x, int y){
            return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length ;
        }
        
    
    
}

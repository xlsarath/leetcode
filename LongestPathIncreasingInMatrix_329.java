//time complexity : O(m * n) if it's nxn matrix : O(n^2)
//space complexity : O(n ^ 2)
public class LongestPathIncreasingInMatrix_329 {


    //using Kahn's algorithm for topographical sort we have O(V + E) but here I think V = m*n and E = m*n so overall complexity is O(2*(m*n) which is O(m*n).
     //space O(m*n)
    int dx[] = {0, 0, 1, -1};
    int dy[] = {1, -1, 0, 0};
    
    public int longestIncreasingPath(int[][] matrix) {
        
        //base check
        if(matrix.length == 0 ) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int inDegree[][] = new int[row][col];
        
        //get Indegree if neighbors are greater than current element.
        for(int i = 0; i < row; i++ ){
            for(int j = 0; j < col; j++){
                for(int k = 0 ; k < 4; k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(isValid(row, col, x, y) && matrix[i][j] < matrix[x][y])
                        inDegree[i][j]++;
                }
            }
        }
        
        //add elements to queue whoose inDegree is 0
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col ; j++){
                if(inDegree[i][j] == 0)
                    q.offer(new int[]{i,j});
            }
        }
        
        //BFS to topological sort 
        int length = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i = 0; i < size; i++ ){
                
                int []temp = q.poll();
                
                for(int k = 0 ; k < 4 ; k++){
                    int x = temp[0] + dx[k];
                    int y = temp[1] + dy[k];
                    
                    if(isValid(row, col, x, y) && matrix[temp[0]][temp[1]] > matrix[x][y] && --inDegree[x][y] == 0)
                        q.offer(new int[]{x, y});
                }
                
                
            }
            
            
            length++;
        }
        
        return length;
        
        
    }
    
    public boolean isValid(int row, int col, int x, int y){
        return x >= 0 && y >= 0 && x < row && y < col;
    }



    /** 
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
        
    */
    
}

//time complexity : O(M * N)
//space complexity : O(M * N)

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(heights == null || heights.length == 0) return result;
        
        int row = heights.length; int col = heights[0].length;
        
        boolean [][] pacific = new boolean[row][col];
        boolean [][] atlantic = new boolean[row][col];
        
        Queue<List<Integer>> pq = new LinkedList<>();
        Queue<List<Integer>> aq = new LinkedList<>();
        
        //vertical borders
        for(int i = 0; i < row; i++){
            pq.offer( Arrays.asList(i, 0));
            aq.offer(Arrays.asList(i, (col - 1)));
            pacific[i][0] = true;
            atlantic[i][col -1] = true;
        }
        
        //horizontal borders
        for(int i = 0 ; i < col; i++){
            pq.offer(Arrays.asList(0, i));
            aq.offer(Arrays.asList(row -1, i));
            pacific[0][i] = true;
            atlantic[row - 1][i] = true;
        }
        
        bfs(heights, pq, pacific);
        bfs(heights, aq, atlantic);
        
        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i,j));
            }
        }
        
        return result;
    }
    
    int dx[] = {-1, 0 , 1, 0};
    int dy[] = {0 , 1, 0, -1};
    
    public void bfs(int[][] heights, Queue<List<Integer>> q, boolean[][] grid){
        
        
        while(!q.isEmpty()){
            
            List<Integer> temp = q.poll();
            
            for(int i = 0; i < 4; i++){
                
                int x = temp.get(0) + dx[i];
                int y = temp.get(1) + dy[i];
                if(isValid(heights, x, y) && !grid[x][y]  && heights[x][y] >= heights[temp.get(0)][temp.get(1)]) {
                    q.offer(Arrays.asList(x, y));
                    grid[x][y] = true;
                }
            }
            
        }
        
        
    }
    
    public boolean isValid(int heights[][], int row, int col){
     return row >= 0 && col >= 0 && row < heights.length && col < heights[0].length;
    }
}
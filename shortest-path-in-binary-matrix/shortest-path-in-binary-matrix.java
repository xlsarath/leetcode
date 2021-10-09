class Solution {
    
     int dx[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int dy[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
         if (grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1) {
            return -1;
        } 
        
        
        Queue<int[]> q = new LinkedList<>();
        
        
        q.offer(new int[]{0,0});
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                int temp[] = q.poll();
                if(temp[0] == grid.length -1 && temp[1] == grid[0].length - 1) return level+1;
                
                for(int k = 0 ; k < 8; k++){
                    
                    int x = dx[k] + temp[0];
                    int y = dy[k] + temp[1];
                    if(isValid(x, y, grid) && grid[x][y] == 0 ){
                        q.add(new int[]{x,y});
                        grid[x][y] = -2;
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    public boolean isValid(int i, int j, int[][] grid){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
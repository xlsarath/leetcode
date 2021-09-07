class Solution {
    
    int dx[] = {-1, 0 , 1, 0};
    int dy[] = {0 , 1, 0, -1};
    public void wallsAndGates(int[][] rooms) {
        
        Queue<int[]> q = new LinkedList<>();
        
        int m = rooms.length;
        int n = rooms[0].length;
        
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(rooms[i][j] == 0)
                    q.offer(new int[]{i,j});
            }
        }
        
        while(!q.isEmpty()){
            
            int[] temp = q.poll();
            
            for(int i = 0 ; i < 4; i++){
                
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];
                
                if(isValid(rooms, x, y) && rooms[x][y] == Integer.MAX_VALUE){
                    rooms[x][y] = rooms[temp[0]][temp[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
            
            
        }
        
    }
    
    public boolean isValid(int[][] rooms, int row, int col){
        return row >= 0 && col >= 0 && row < rooms.length && col < rooms[0].length;
    }
}
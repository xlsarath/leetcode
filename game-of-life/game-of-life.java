/**
time complexity : O(m *n)
space complexity : O(1)
*/
class Solution {
    
    int dx[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int dy[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    
    public int countNeighbors(int board[][], int row, int col){
        
        int neighbors = 0;
        
        for(int i = 0 ; i < 8; i++){
            
            int x = row + dx[i];
            int y = col + dy[i];
            
            if(isValid(board, x, y) && (board[x][y] == 1 || board[x][y] == -1 ))
                    neighbors++; 
        }
        
        return neighbors;
    }
    
    public boolean isValid(int[][] board, int row, int col){
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
    }
    
    public void gameOfLife(int[][] board) {
        
        if(board.length==0) return ;
        
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                
                    int count =  countNeighbors(board, i, j);
                    
                    if(board[i][j] == 1){ // alive
                        if(count <2 || count > 3) // points 2 and 3
                            board[i][j] = -1; //will die
                    } else {
                        if(count == 3)
                            board[i][j] = 2; // point 4
                    }
            }
        }
        
        
        //lets turn -1 --> 0(dead) and 2 ---> 1(alive)
        
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
        
        
    }
}
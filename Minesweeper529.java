import java.util.LinkedList;
import java.util.Queue;

//time complexity : O(n)
//space complexity : O(n)
//leet code : yes
//steps : DFS and BFS both

public class Minesweeper529 {
    
        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[] = {-1,  0,  1, -1, 1, -1, 0, 1};

    /**  BFS APPROACH
        public char[][] updateBoard(char[][] board, int[] click) {
            if(board == null || board.length == 0) return board;
            
            int m = board.length;
            int n = board[0].length;
            
            int row = click[0], col = click[1];
            
            if(board[row][col] == 'M'){
                board[row][col] = 'X';
                return board;
            }
            
           // dfs(board, row, col);
            
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {row, col});
            board[row][col] = 'B';
            
            while(!queue.isEmpty()){
                int[] current = queue.poll();
                row = current[0];
                col = current[1];
                int count = countMines(board,row,col );
            
            if(count == 0) {
                for(int i=0; i<8; i++){
                    int x = row +dx[i];
                    int y = col +dy[i];
                    if(isValid(board, x, y) && board[x][y]=='E')    {                                        board[x][y] = 'B';
                        queue.add(new int[]{x,y});
                                                                    }
                }
            } else {
                board[row][col] = (char) (count + '0');
            }
            }
            
            
            return board;
        } */
        
        public char[][] updateBoard(char[][] board, int[] click) {
            if(board == null || board.length == 0) return board;
            
            int row = click[0], col = click[1];
            
            if(board[row][col] == 'M'){
                board[row][col] = 'X';
                return board;
            }
            
            dfs(board, row, col);
            
            return board;
        }
        
        private void dfs(char[][] board, int row, int col){
            
            int count = countMines(board, row, col);
            
            if(count == 0) {
                board[row][col] = 'B';
                for(int i=0; i<8; i++){
                    int x = row +dx[i];
                    int y = col +dy[i];
                    if(isValid(board, x, y) && board[x][y]=='E') dfs(board,x,y);
                }
            } else {
                board[row][col] = (char) (count + '0');
            }
        }
        
        
        private int countMines(char[][] board, int row, int col){
            int count = 0;
            for(int i=0; i<8 ; i++){
                int x = row + dx[i];
                int y = col + dy[i];
                if(isValid(board, x, y) && board[x][y] =='M') count++;
            }
            return count;
        }
        
        private boolean isValid(char [][] board, int row, int col){
            return  row < board.length && col < board[0].length && row >= 0 && col >= 0;
        }
    }
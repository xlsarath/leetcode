//time complexity : O(N)
//space complexity : O(L) -- length of given search word
class Solution {
    public boolean exist(char[][] board, String word) {
        
        if(word.length() == 0) return true;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backTrack(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};
    public boolean backTrack(char[][] board, int row, int col, int idx, String word){
        
        if(idx == word.length()) return true;
        
        if(isValid(board, row, col) && board[row][col] == word.charAt(idx)){
             board[row][col] = '$';
            for(int i = 0 ; i < 4; i++){
                int x = row + dx[i];
                int y = col + dy[i];
                if(backTrack(board, x, y, idx+1, word)) 
                    return true;
            }
            board[row][col] = word.charAt(idx);
        }
        
        return false;
    }
    
    public boolean isValid(char[][] board, int x, int y){
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }
}
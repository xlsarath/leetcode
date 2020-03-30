//time complexity : O(MxN)  k length of string
//space complexity : O(K)
//leet code : yes
//steps : used back tracking to check the whether word exists and update current char in board matrix to $ to avoid infinite calls.
class Solution {
    
    int[] dx = new int[]{-1,0,1,0};
    int[] dy = new int[]{0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                
                if(backTracking(board,word,i,j,0)){
                    return true;
                }
                
            }
        }
        return false;
    }
    
    
    public boolean backTracking(char[][] board, String word, int row, int col, int cursor){
        
        //isGoal
        if(cursor==word.length()){
            return true;
        }
        
        
        if(isValid(board,row,col) &&  board[row][col]== word.charAt(cursor)){
            
            board[row][col]='$';
            for(int i=0;i<4;i++){
                int x = row+dx[i];
                int y = col + dy[i];
                
               if(backTracking(board,word,x,y,cursor+1)) {
                   return true;
               }
        }
           board[row][col] = word.charAt(cursor);
        
    }
                  return false;
                  }
    public boolean isValid(char[][] board, int row, int col){
        return row>=0 && col >=0 && row<board.length && col<board[0].length;
    }
    
}
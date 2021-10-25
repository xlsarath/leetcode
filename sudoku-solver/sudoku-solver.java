class Solution {
    public void solveSudoku(char[][] board) {
        
        HashMap<Integer,HashSet<Integer>> rowMap = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> colMap = new HashMap<>();
        HashMap<String,HashSet<Integer>> squareMap = new HashMap<>();
        
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                        rowMap.putIfAbsent(i, new HashSet<>());
                        rowMap.get(i).add(board[i][j]-'0');
                        colMap.putIfAbsent(j, new HashSet<>());
                        colMap.get(j).add(board[i][j]-'0');
                        String key  = (i / 3)+""+(j / 3);
                        squareMap.putIfAbsent(key, new HashSet<>());
                        squareMap.get(key).add(board[i][j]-'0');
                    }
                else
                {
                   rowMap.putIfAbsent(i, new HashSet<>()); 
                   colMap.putIfAbsent(j, new HashSet<>());
                    String key1  = (i / 3)+""+(j / 3);
                    squareMap.putIfAbsent(key1, new HashSet<>());
                }
            }
        }
    
       
        
       
        backTrack(board, rowMap, colMap, squareMap);
            
       

    }
    
    
    public boolean backTrack(char[][] board, HashMap<Integer,HashSet<Integer>> rowMap,
                        HashMap<Integer,HashSet<Integer>> colMap,
                        HashMap<String,HashSet<Integer>> squareMap){
        
        
        
         for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board.length; j++){
                
                if(board[i][j] == '.'){
                    for(int k = 1 ; k <= 9; k++){
                        if(isValid(i, j, k, rowMap, colMap, squareMap)){
                            board[i][j] = (char) (k+'0');
                            rowMap.get(i).add(k);
                            colMap.get(j).add(k);
                            String key  = (i / 3)+""+(j / 3);
                            squareMap.get(key).add(k);
                            if(backTrack(board, rowMap, colMap, squareMap))
                                    return true;
                            board[i][j] = '.';
                            rowMap.get(i).remove(k);
                            colMap.get(j).remove(k);
                            squareMap.get(key).remove(k);
                        }
                    }
                    return false;
                }
            }
        }
        

        
        return true;
    }
    
    
    public boolean isValid(int i, int j, int k, HashMap<Integer,HashSet<Integer>> rowMap,
                        HashMap<Integer,HashSet<Integer>> colMap,
                        HashMap<String,HashSet<Integer>> squareMap){
     
        if(rowMap.get(i).contains(k)) return false;
        if(colMap.get(j).contains(k)) return false;
        
                            String key  = (i / 3)+""+(j / 3);
        
        if(squareMap.get(key).contains(k)) return false;
        return true;
    }
}

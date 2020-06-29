//time complexity : O(n)
//space complexity : O(n)
//leet code : yes
//steps: BFS approach
public class SnakesAndLadder909 {

        public int snakesAndLadders(int[][] board) {
            
            if(board == null || board.length == 0) return 0;
            
            int rows = board.length;
            int cols = board[0].length;
            int N = rows * cols;
            int flattenBoard[] = new int[N];
            boolean leftToRight = true;
            
            int i = rows -1, j=0;
            int index =0;
            while(i>=0 && j>=0){
                if(board[i][j] == -1){
                    flattenBoard[index] = -1;
                } else {
                    flattenBoard[index] = board[i][j] -1;
                }
                
                index++;
                
                if(leftToRight){
                    j++;
                } else {
                    j--;
                }
                
                if (j >= cols){
                    j--;
                    i--;
                    leftToRight = !leftToRight;
                } 
                 if (j < 0) {
                     j++;
                     i--;
                     leftToRight = !leftToRight;
                 }
                    
                }
            
            Queue<Integer>  queue = new LinkedList<>();
            int minSteps = 0;
            
            queue.add(0);
            flattenBoard[0] = -2;
            
            while(!queue.isEmpty()){
                int countNodesLevel = queue.size();
                
                for( i=0; i<countNodesLevel; i++){
                    int current = queue.poll();
                    
                    if(current == N-1) return minSteps;
                
                    for(j=1;j<7;j++){
                        int child = current+j;
                        if(child < N && flattenBoard[child] != -2){
                            if(flattenBoard[child] >= 0){
                                queue.add(flattenBoard[child]);
                            } else {
                                queue.add(child);
                            }
                            flattenBoard[child]= -2;
                        }
                    }
                
                
                }
                            minSteps++;
    
    
            }
            return -1;
            }
            
            
        
    }
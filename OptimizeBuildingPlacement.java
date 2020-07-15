//time comexity : O(n)
//space complexity : O(rxw * n) basically gridsize * n
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OptimizeBuildingPlacement {
    int result = Integer.MAX_VALUE;
    int []dx = new int[]{-1, 0, 1, 0};
    int []dy = new int[]{0, 1, 0, -1};

    public int findMinDistance(int H, int W, int n){
        
        int[][] board = new int[H][W];

            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    board[i][j] = -1;
                }
            }
            System.out.println("fin");
            backTrack(board, n , 0 , 0, H, W);

            return result;

    }

    private void backTrack(int[][] board, int n, int row, int col, int H, int W) {

        //base
        if(n==0){
            for(int []r : board){
                System.out.println(Arrays.toString(r));
            }
            System.out.println();
            bfs(board, H, W);
            return;
        }

        //logic to handle col val
        if(col >= W){
            row++;
            col = 0;
        }


        for(int i = row ; i < H; i++){
            for(int j = col; j < W; j++){

                board[i][j] = 0;
                backTrack(board, n-1, i, j+1, H, W);
                board[i][j] = -1;

            }
            col=0;
        }

        //return;

    }

    private void bfs(int[][] board, int h, int w) {


        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        

        for(int i =0 ; i < h; i++){
            for(int j = 0; j < w ; j++){

                if(board[i][j] == 0){
                    visited[i][j] = true;
                    q.add(new int[]{i , j});
                } 
            }
        }

        int distance = 0;


        while(!q.isEmpty()){

            int currentLevel = q.size();

            for(int i = 0; i < currentLevel; i++){
                int [] current = q.poll();

                for(int j = 0; j < 4; j++){

                    int x = current[0] + dx[j];
                    int y = current[1] + dy[j];

                    if(isValid(x,y,h,w) && !visited[x][y]){
                        visited[x][y] = true;
                        q.add(new int[]{x,y});
                    }
                }
            }
            distance++;
        }

        result = Math.min(result,distance-1);
          
    }

    private boolean isValid(int x, int y, int row, int col) {
        return x < row && x >= 0 && y < col && y >= 0; 
    }

    public static void main(String[] args) {
        System.out.println(new OptimizeBuildingPlacement().findMinDistance(4, 4, 3));
    }

}
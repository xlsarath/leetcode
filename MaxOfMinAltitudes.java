
public class MaxOfMinAltitudes {




    public static void main(String[] args) {
        
        int grid[][] = {{1,2,3}, {4,5,1}};
        
        System.out.println(new MaxOfMinAltitudes().calculateMaxMinAlt(grid));
        
    }

    private int calculateMaxMinAlt(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];
        
        dp[0][0] = Integer.MAX_VALUE;

        for(int i = 1; i < col; i++) dp[0][i] = Math.min(dp[0][i-1],grid[0][i]);

        for(int i = 1; i < row; i++) dp[i][0] = Math.min(dp[i-1][0],grid[i][0]);

        for(int i = 1; i < row ; i++){
            for(int j = 1; j < col; j++){
                if(i == row -1  && j == col-1) dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                else {
                    int score1 = Math.min(dp[i][j-1],grid[i][j]);
                    int score2 = Math.min(dp[i-1][j],grid[i][j]);
                    dp[i][j] = Math.max(score1, score2);
                }

            }
        }
        
    return dp[row-1][col-1];
    }

}
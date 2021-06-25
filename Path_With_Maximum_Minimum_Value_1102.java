
public class Path_With_Maximum_Minimum_Value_1102 {

    private static int maxScore2D(int[][] grid) {
        // Assume there is at least one element
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];
        // Init
        dp[0][0] = Integer.MAX_VALUE; // first entry is not considered
        for (int i = 1; i < r; ++i) dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
        for (int j = 1; j < c; ++j) dp[0][j] = Math.min(dp[0][j - 1], grid[0][j]);
        // DP
        for (int i = 1; i < r; ++i) { // row by row
          for (int j = 1; j < c; ++j) {
            if (i == r - 1 && j == c - 1) {
              dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // last entry is not considered
            } else {
              int score1 = Math.min(dp[i][j - 1], grid[i][j]); // left
              int score2 = Math.min(dp[i - 1][j], grid[i][j]); // up
              dp[i][j] = Math.max(score1, score2);
            }
          }
        }
        return dp[r - 1][c - 1];
      }
      



        public static void main(String[] args) {
          int[][] grid1 = new int[][] { {5, 1}, {4, 5} };                        // 4
          int[][] grid2 = new int[][] { {5, 1, 7}, {4, 8, 5} };                  // 4
          int[][] grid3 = new int[][] { {1, 9, 9}, {9, 9, 9}, {9, 9, 9} };       // 1
          int[][] grid4 = new int[][] { {10, 7, 3}, {12, 11, 9}, {1, 2, 8} };    // 8
          int[][] grid5 = new int[][] { {20, 20, 3}, {20, 3, 20}, {3, 20, 20} }; // 3
          System.out.println("grid1: Expected: 4, Actual: " + maxScore2D(grid1));
          System.out.println("grid2: Expected: 4, Actual: " + maxScore2D(grid2));
          System.out.println("grid3: Expected: 1, Actual: " + maxScore2D(grid3));
          System.out.println("grid4: Expected: 8, Actual: " + maxScore2D(grid4));
          System.out.println("grid5: Expected: 3, Actual: " + maxScore2D(grid5));
        }
}
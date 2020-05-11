//time complexit : O(m x n)
//space complexity : O(mxn)
//leetcode : yes
//steps : implemented using DP.
class Solution {
 
 
    public int maximalSquare(char[][] matrix) {
        
     if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
            
        int[][] dp = new int[row][col];
        int maxLen = 0;
        
        //filling first row as it is
        for(int i=0; i< row; i++){
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            maxLen = Math.max(maxLen,dp[i][0]);
        }
        //similarly column
        for(int j=0;j<col;j++){
            dp[0][j] = matrix[0][j] =='0' ? 0 : 1;
            maxLen = Math.max(maxLen,dp[0][j]);
        }
        
        for(int i =1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]= Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]) +1;
                    maxLen = Math.max(maxLen,dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
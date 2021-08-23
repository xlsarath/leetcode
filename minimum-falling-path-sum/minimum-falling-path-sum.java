/**
time complexity : O(n x n)
space complexity : O(1)
*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return 0;
        
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0 ; j < matrix.length; j++){
                
                if(j == 0)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                else if(j == matrix.length - 1)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                else
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], Math.min(matrix[i-1][j+1], matrix[i-1][j-1]));
                
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++)
            res = Math.min(res,matrix[matrix.length-1][i]);
        
        return res;
    }
}
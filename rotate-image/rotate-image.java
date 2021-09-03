class Solution {
    public void rotate(int[][] matrix) {
     
        int n = matrix.length;
         
       for(int i = 0;i<(n+1)/2;i++) // for odd sized n*n matrix i.e 7x7
        {
            for(int j=i;j<n-1-i;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
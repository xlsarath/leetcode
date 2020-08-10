/*
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
*/


public class RotateImage48 {


        public void rotate(int[][] matrix) {
         
            int n = matrix.length;
            
           for(int i = 0;i<(n+1)/2;i++) 
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
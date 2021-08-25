//time complexity : O(m * n)
//space complexity : O(mn) <-- if result is excluded it's O(1);
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
          if(matrix==null||matrix.length==0) return new int[0];
        
        int row=0,col=0,direction =1,i=0; // up/down 1/-1
        int m = matrix.length;
        int n = matrix[0].length;
        int result[] = new int[m*n];
        
        while(i<m*n){
            result[i] = matrix[row][col];
            
            if(direction ==1){// up cases
                if(col==n-1){
                    row++;
                    direction =-1;
                }
                else if(row==0){
                    col++;
                    direction =-1;
                }
                else {
                    row--;
                    col++;
                }
            }
            else{
                if(row == m-1){
                    col++;
                    direction =1;
                }
                else if(col==0){
                    row++;
                    direction =1;
                }
                else {
                    row++;
                    col--;
                }
            }
            i++;
        }
        return result;
    }
}
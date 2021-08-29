//time complexity : O(m+n);
//space complexity : O(1)
class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
           
            int row = matrix.length - 1, col = 0;
            
            while(row >= 0 && col < matrix[0].length){
                
                if(matrix[row][col] == target) return true;
                else if(target > matrix[row][col]) col++;
                else row--;
            }
           
            return false;
        }
}


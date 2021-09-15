class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        
        if(matrix == null || matrix[0].length == 0) return result;
        
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        
         
           
        while(left <= right && top <= bottom){
           
            //left to right
            for(int cursor = left; cursor <= right; cursor++)
                result.add(matrix[top][cursor]);
            
            top++;
        
            //top to bottom
            for(int cursor = top ; cursor <= bottom; cursor++)
                result.add(matrix[cursor][right]);
            
            right--;
            
            //right to left
            if(top <= bottom)
                for(int cursor = right; cursor >= left; cursor--)
                    result.add(matrix[bottom][cursor]);
            
            
            bottom--;
            
            //bottom to top
            if(left <= right)
                for(int cursor = bottom; cursor >= top; cursor-- )
                    result.add(matrix[cursor][left]);
            
            
            left++;
        }
        
        return result;
        
    }
}
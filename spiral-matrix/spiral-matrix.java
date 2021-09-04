class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<>();
        
        if(matrix.length == 0) return res;
        
        int top = 0, bottom = matrix.length-1, right = matrix[0].length-1, left = 0;
        
        while( top <= bottom && left <= right){
            
            //left to right
           for(int cursor = left; cursor <= right; cursor++)
               res.add(matrix[top][cursor]);
            
            top++;
            
            //right to bottom
            for(int cursor = top; cursor <= bottom; cursor++ )
                    res.add(matrix[cursor][right]);
            
            right--;
            
            // bottom to left
            if(top <= bottom)
                for(int cursor = right; cursor >= left; cursor--)
                    res.add(matrix[bottom][cursor]);
            
            bottom--;
            
            //left to top
            if(left <= right)
                for(int cursor = bottom; cursor >= top ; cursor--)
                    res.add(matrix[cursor][left]);
             
            left++;   
            
        }
        
        return res;
        
    }
}
//time complexity : O(mxn)
//space complexity : O(mxn)
//leet code execution : successfull
//steps : initialise four variables namely top,bottom,left and right. which help in navigating through martrix.
// 1) for travelling left to right, keep row constant(top) and iterate left(col) until right. and increment top to next row
// 2) for top to bottom traversal, keep incrementing row of right until cursor reaches bottom; and decrement right;
// 3) for left to right, keep decrementing right until cursor reaches first row(left) and decrement bottom by one step;
// 4) for bottom to top, keep decrementing left until curosr reaches top; and increment left to next col.
// note : check for proper conditions for 3 and 4 before entering into loop (top<=bottom),(left<=right)

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix54{


    public List<Integer> spiralOrder(int[][] matrix){
        if(matrix==null||matrix.length==0) return null;
        int m = matrix.length; // rows
        int n = matrix[0].length; //columns
        int top=0,bottom =  m-1, left = 0,right =n-1;
        List<Integer> result = new ArrayList<>();
        while(top<=bottom && left <= right){
            //top row ; left ---> right
            for(int cursor = left; cursor <=right; cursor++){
                result.add(matrix[top][cursor]);
            }
            top++;
            //top --> bottom
            for(int cursor = top;cursor<=bottom;cursor++){
                result.add(matrix[cursor][right]);
            }
            right--;
            //right --> left
            if(top<=bottom){
            for(int cursor = right;cursor>=left;cursor--){
                result.add(matrix[bottom][cursor]);
            }
        }
            bottom--;
            if(left<=right){
            for(int cursor=bottom;cursor>=top;cursor--){
                result.add(matrix[cursor][left]);
            }
        }
            left++;

        }
        return result;
     }


    public static void main(String[] args) {
        SpiralMatrix54 sm = new SpiralMatrix54();
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(sm.spiralOrder(matrix));
        
    }
}
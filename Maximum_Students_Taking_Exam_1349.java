import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Maximum_Students_Taking_Exam_1349 {

    
    int r, c;
    int[][] memo;
    List<Integer> masks;
    
    public int maxStudents(char[][] seats) {
        r = seats.length;
        c = seats[0].length;
        memo = new int[r][1<<c];
        //System.out.println(1<<c);
        


        for (int i = 0; i < r; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(Arrays.deepToString(memo));
        return getMax(seats, 0, 0);
    }
    
    private int getMax(char[][] seats, int curRow, int prevRowMask) {
        if (curRow == r) {
            return 0;
        }
        if (memo[curRow][prevRowMask] != -1){
            return memo[curRow][prevRowMask];
        }
        masks = new LinkedList<>(); // reset the masks list for backtrack
        backtrack(seats[curRow], 0, prevRowMask, 0); // backtrack results store in masks list
        int res = 0;
        for (int m : masks) {
            res = Math.max(res, Integer.bitCount(m) + getMax(seats, curRow + 1, m));
        }
        memo[curRow][prevRowMask] = res;
        return res;
    }
    
    // this returns all combination of legal seat assignment for a given row based on prevous row's mask
    private void backtrack(char[] seats, int cur, int prevRowMask, int curRowMask) {
        if (cur == c) {
            masks.add(curRowMask);
            return;
        }
        // cur seat is not taken
        backtrack(seats, cur + 1, prevRowMask, curRowMask);
        
        // cur seat is taken, check if left, upper left and upper right positions are empty
        if (seats[cur] != '#' 
            && (cur == 0 || (((curRowMask & (1 << (cur-1))) == 0) && (prevRowMask & (1 << (cur-1))) == 0))
            && (cur == c - 1 || ((prevRowMask & (1 << (cur+1))) == 0))) {
            curRowMask |= (1 << (cur));
            backtrack(seats, cur + 1, prevRowMask, curRowMask);
            curRowMask ^= (1 << (cur));
        }
    }
         
     
 public static void main(String[] args){

                    // 0  1   2   3   4    5
    char[][] seats= {{'#','.','.','.','#'},{'.','#','.','#','.'},{'.','.','#','.','.'},{'.','#','.','#','.'},{'#','.','.','.','#'}};

    System.out.println(new Maximum_Students_Taking_Exam_1349().maxStudents(seats));



 }

}

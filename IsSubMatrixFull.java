import java.util.*;


public class IsSubMatrixFull {

public Boolean[] isSubMatrixFull(int[][] matrix){

    
    List<Boolean> result = new ArrayList<>();

    for(int i = 0 ; i <= matrix[0].length - 3 ; i ++) {

        if(CheckWindow(matrix, i))
                result.add(true);
        else 
                result.add(false);
    }
    
    Boolean b[] = new Boolean[result.size()];
    result.toArray(b);

    return b;

}


    private boolean CheckWindow(int[][] matrix, int k) {

        Set<Integer> nums = new HashSet<>();
        for(int i = 1 ; i < 10; i++) nums.add(i);

        for(int i = 0 ; i < 3; i++){
            for(int j = k ; j < k+ 3; j++){
               // System.out.println(matrix[i][j]);
                if(nums.contains(matrix[i][j])) nums.remove(matrix[i][j]);
            }
        }


        System.out.println(nums.size());
    return nums.size() == 0;
}

public static void main(String[] args) {
        

        int matrix[][] = {{1,2,3,2,5,7},{4,5,6,1,7,6},{7,8,9,4,8,3}};
        for (boolean b : new IsSubMatrixFull().isSubMatrixFull(matrix))
                System.out.println(b);

    }

}
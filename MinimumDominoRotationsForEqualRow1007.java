
public class MinimumDominoRotationsForEqualRow1007 {
    public int minDominoRotations(int[] A, int[] B) {
        
        int rotations = check(A, B, A[0]);
        if(rotations != -1) return rotations;
       return check(A, B, B[0]);
        
    }
    
    public int check(int[] A, int[] B, int x){
        
        int top = 0,bottom = 0;
        
        for(int i = 0; i < A.length; i++){
            
            if(A[i] != x && B[i] != x) return -1;
            
            if(A[i] != x) top++;
            if(B[i] != x) bottom++;
            
        }
        
        return Math.min(top,bottom);
        
    }
    public static void main(String[] args) {
        System.out.println(new MinimumDominoRotationsForEqualRow1007().minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
    }
}
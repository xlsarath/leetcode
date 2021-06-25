//time complexity : O(m x n)
//Space Complexity : O(1)
//Leet code execution : successful
//Steps: There's  a repeating sub problem in this, so DP is implemeted by add min value from neighbouring elements to the value.
// And continuing this till the length will make last row filled with accumlative miv paths. Min of these values is the ans.
class MinFallingPath931 {
        public int minFallingPathSum(int[][] A) {
            
            if(A==null|A.length==0) return 0;
            int n = A.length;
            for(int i=1;i<n;i++){
                for (int j=0;j<n;j++){
                    if(j==0){
                        A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);
                    }
                    else if(j==n-1){
                        A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j-1]);
                    }
                    else {
                        A[i][j] = A[i][j] + Math.min(A[i-1][j-1],Math.min(A[i-1][j], A[i-1][j+1]));
                    }
                }
            }
           int  min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
                min = Math.min(min, A[n-1][i]);
          
        return min;
    }


    public static void main(String[] args) {
        
        MinFallingPath931 min = new MinFallingPath931();
        int A[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(min.minFallingPathSum(A));
    }
}
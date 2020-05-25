//time complexity : O(mn)
//space complexity : O(mn)
//leet code : yes
//steps: formulate DP array and return last element of array.

public class UniquePaths62 {

        public int uniquePaths(int m, int n) {
            
            int distinctWays[][] = new int[m][n];
            
            for(int i=0;i<n;i++){
                distinctWays[0][i] =1;
                
            }
            
            for(int j=1; j<m;j++){
                distinctWays[j][0]=1;
            }
            
            for(int i=1;i<m;i++){
                for(int j=1; j<n; j++){
                    distinctWays[i][j] = distinctWays[i-1][j] + distinctWays[i][j-1];
                }
            }
            
            return distinctWays[m-1][n-1];
        }


}
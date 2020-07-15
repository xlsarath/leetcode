//time complexity :  O(K * N)
//space complexity : O(k * N)
//leet code :  yes
//approach : DP

public class superEggDrop887 {

    public int superEggDrop(int K, int N) {

        int floors[][] = new int[N+1][K+1];

        for(int attempt = 1; attempt <= N; attempt++ ){
            for(int k = 1; k <= K; k++){

                //floors[attempt][k] = 1 + break + !break
                floors[attempt][k] = 1 + floors[attempt-1][k-1] + floors[attempt-1][k];

                if(floors[attempt][k] >= N) return attempt;

            }
        }
        return N;


        /* non optimised version 
         int[][] dp = new int[K + 1][N + 1];
 	        for(int j = 1; j < dp[0].length; j++){
 	            dp[1][j] = j;
 	        }

 	        for(int i = 2; i <= K; i++){
 	            for(int j = 1; j <= N; j++){
 	                dp[i][j] = Integer.MAX_VALUE;
 	                for(int l = 1; l <= j; l++){
 	                    dp[i][j]= Math.min(dp[i][j],1 + Math.max(dp[i - 1][l - 1], dp[i][j - l]));
 	                }
 	            }
 	        }
             return dp[K][N];
             */
    }
public static void main(String[] args) {
    System.out.println( new superEggDrop887().superEggDrop(3, 14));
}

}
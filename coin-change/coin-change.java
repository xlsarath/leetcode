class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0) return -1;
        
        int m = coins.length;
        int n = amount;
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i = 0 ; i <= m; i++)
            dp[i][0] = 0;
        
        for(int i = 1 ; i <= n; i++)
            dp[0][i] = 999;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1 ; j <= n; j++){
                
                //if j is less than amount
                if( j < coins[i-1])
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]]+1);
                }
                
            }
        }    
         
                if(dp[m][n] >= 999) return -1;

        
        return dp[m][n];
    }
}
// dfs time complexity : O(2^n)
//DP : time complexity : O(n)
//space complexity : O(n) 
class Solution {
    
    public int climbStairs(int n){
        
        if(n == 1) return n;
        
        int[] dp = new int[n];
        
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i -2];
        }
        return dp[n-1];
    }
    
    /**
    public int climbStairs(int n) {
        return climbStairs(0, n);
    }
    
    public int climbStairs(int i, int n){
        if( i > n) return 0;
        if(i == n) return 1;
        
        return climbStairs(i+1, n) + climbStairs(i+2, n);
    } */
}
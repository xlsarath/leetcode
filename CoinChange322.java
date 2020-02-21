/**
 * time complexity ; M x N (m is coins.length and N is amount.length)
 * space complexity : O(n)
 * leet code execution : successful
 * steps: form a DP matrix of size [coins.length+1][amt.length+1]. Fill up first col with 0's and forst row with Max number.
 *         now using coin value ..while iterating over amount values step back[steps are based on coin value] at the index add one.
 *          now compare this value with above value and print min of both. once array iterated completely the last dp[m][n] will have the required ans.
 */

class CoinChange322 {


    //DP method
    public int coinChange2(int[] coins, int amount){

        //base case
        if(coins.length==0||coins==null) return 0;

        int m = coins.length;
        int n =amount;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0]=0;
        for(int i=1;i<=n;i++)
            dp[0][i]=9999;
        for(int i=1; i<=m; i++){
                for(int j=1;j<=n;j++){
                    //if amount < denomination
                    if(j<coins[i-1]){
                        dp[i][j]=dp[i-1][j];
                       // System.out.print(i);
                       // System.out.print(j);
                       // System.out.println(dp[i][j]);
                    } 
                    else{
                    System.out.print(dp[i][j-coins[i-1]]+1);
                    dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                   // System.out.println(dp[i][j]);

                    }
                }
        }
        if(dp[m][n]>=9999) return -1;
        else return dp[m][n];
        }

    //using recurssion
    
    public int coinChange(int[] coins, int amount){
        return helper(coins,amount, 0, 0);
    }

    private int helper(int[] coins, int amount, int i, int min) {
        //base
        if(i >=coins.length || amount <0) return -1;
        if(amount==0) return min;
        //logic
        //chose
        int case1 = helper(coins, amount-coins[i], i, min+1);
        //not chose
        int case2 = helper(coins, amount, i+1, min);
        if(case1==-1)return case2;
        if(case2==-1)return case1;
        return Math.min(case1, case2);
    }

    public static void main(String[] args) {

        CoinChange322 cc = new CoinChange322();
        int arr[]={1,2,5};
        System.out.println(cc.coinChange2(arr,11));
        
    }
}
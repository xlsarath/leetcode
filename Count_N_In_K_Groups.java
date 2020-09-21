import java.util.Arrays;

//time complexity : N^K <-- dfs
// time complexity : O(N^2 * k) <-- dp
//sapce complexity : O(n)
//space complexity : O(1);
public class Count_N_In_K_Groups {


   static int dp[][][] = new int[500][500][500];

    public static int calculate(int N, int k){

        return cal(0, 1, N, k);
    }


    private static int cal(int current, int prev, int target, int k) {
        
       if(current == k){
           if(target == 0) return 1;
           else return 0;
       }

       if(target == 0) return 0;

       int ans = 0;
       for(int i = prev; i <= target; i++){
           ans += cal(current+1, i, target-i, k);
       }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(calculate(24, 5));
        System.out.println(calculateDP(24,5));
        
    }

    private static int calculateDP(int i, int j) {

        for(int[][] row : dp)
            for(int[] rowCol : row)
                Arrays.fill(rowCol,-1);

        return calDP(0, 1, i, j);
    }

    private static int calDP(int current, int prev, int target, int k) {


        if(current == k){
            if(target == 0) return 1;
            else return 0;
        }

        if(target == 0) return 0;

        if(dp[current][prev][target] != -1)
            return dp[current][prev][target];

        int ans = 0;
        
        for(int i = prev; i <= target; i++)
            ans += calDP(current+1, i, target-i, k);



        return dp[current][prev][target] = ans;
    }

}
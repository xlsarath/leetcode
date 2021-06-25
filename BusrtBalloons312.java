//time complexity : O(n^3)
//space complexity : O(n^2)
//leet code : yes
//steps : DP approach
public class BusrtBalloons312 {


    public int maxCoins(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int [][] gain = new int [n][n];

        for(int len = 1; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                //size = e - s + 1;
                //size = s - 1 = i + len -1
                int j = i + len - 1;

                for(int k = i; k <= j; k++){
                    int leftGain = 0, rightGain = 0;
                if(k != i) leftGain = gain[i][k-1];
                if( k!= j) rightGain = gain[k+1][j];

                int leftBalloonValue = 1, rightBalloonValue = 1;

                if(i != 0) leftBalloonValue = nums[i-1];
                if(j != n-1) rightBalloonValue = nums[j+1];

                gain[i][j] = Math.max(gain[i][j], leftGain
                                + leftBalloonValue * nums[k] * rightBalloonValue 
                                + rightGain);

                }

            }
        }
        return gain[0][nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new BusrtBalloons312().maxCoins(new int []{3,1,5,8}));
    }
}
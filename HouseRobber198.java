/**
 * time complexity : O(k) --- k is houses
 * space complxity : O(1)
 * leet code execution : successful 
 * Steps: here am considering two options, chosen and not chosen. for every iternation over houses, thier max of (chosen and not_chosen) is considered towards final sol.
 *          once iteration finishes of the max of chosen and not_chosen will have ans.
 */

class HouseRobber198 {

    private int rob(int arr[]){
        if(arr==null||arr.length==0) return 0;
        int not_chosen =0;
        int chosen = arr[0];
        for(int i=1;i<arr.length;i++){
            int temp = not_chosen;
            not_chosen= Math.max(chosen,not_chosen);
            chosen =temp+arr[i];
        }
        return Math.max(chosen,not_chosen);
    }


    private int rob2(int arr[]){
        if(arr==null||arr.length==0) return 0;
        int [][]dp = new int[arr.length][2];
        dp[0][0] = 0;
        dp[0][1] = arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] =dp[i-1][0]+arr[i];
        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }

   /** 
    * Recurssion
    private int rob(int []arr){
       return  helper(arr,0,0);
    }


    private int helper(int[] arr, int i, int max) {
        
        if(i>=arr.length) return max;
        //logic
        //chose
        int case1 = helper(arr, i+2, max+arr[i]);
        int case2 = helper(arr,i+1,max);

        return Math.max(case1,case2);
    }
*/ 
    public static void main(String[] args) {
    
        HouseRobber198 rob = new HouseRobber198();
        int arr[] = {1,2,3,4,2,3,1};
        System.out.println(rob.rob(arr));
        System.out.println(rob.rob2(arr));

}


}
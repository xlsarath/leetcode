/**
time complexity : O(n)
space complexity : O(n)
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        
     if(nums==null||nums.length==0)return 0;

        int max = Arrays.stream(nums)
                        .max()
                        .getAsInt();
        
        int dp[] = new int[max + 1];
        
        for(int i = 0; i < nums.length; i++)
            dp[nums[i]] = dp[nums[i]] + nums[i];  
        
        int skip = 0, take =0;
        
        for(int i = 0; i < dp.length; i++){
            int curr_skip = Math.max(skip,take);
            int curr_take = skip + dp[i];
            skip = curr_skip;
            take = curr_take;
        }
        
        return Math.max(skip,take);
        
    }
}
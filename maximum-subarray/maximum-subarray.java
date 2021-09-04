class Solution {
    public int maxSubArray(int[] nums) {
         if(nums.length == 0) return 0;
        
        int rSum = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            rSum = Math.max(nums[i], nums[i]+rSum);
            res = Math.max(res,rSum);
        }
        
        return res;
    }
}


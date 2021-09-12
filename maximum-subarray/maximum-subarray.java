class Solution {
    public int maxSubArray(int[] nums) {
        
        int rSum = nums[0]; int res = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            rSum = Math.max(nums[i], rSum + nums[i]);
            res = Math.max(res, rSum);
        }
        return res;
    }
}
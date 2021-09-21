class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int res = nums.length + 1;
        int start = 0;
        int rSum = 0;
        
        for(int end = 0; end < nums.length; end++){
            
            rSum += nums[end]; 
            
            while(rSum >= target){ // greater than or equal to target
                rSum -= nums[start];
                res = Math.min(res, end - start + 1);
                start++;
            }
            

            
        }
        return res == nums.length+1 ? 0 : res;
        
    }
}
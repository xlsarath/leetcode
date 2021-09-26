class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(nums == null || k <= 1) return 0;
        
        //sliding window
        int start = 0; int product = 1;
        int result = 0;
        for(int end = 0 ; end < nums.length; end++){
            
            product = product * nums[end];
            
            while(product >= k){
                product = product / nums[start++];
            }
            
            result += end - start + 1;
        }
     return result;   
    }
}
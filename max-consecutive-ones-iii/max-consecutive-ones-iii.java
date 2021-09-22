class Solution {
    public int longestOnes(int[] nums, int k) {
        
        if(nums == null || nums.length < k) return nums.length;
        
        int start = 0 ;
        int res = 0;
        int countOfZeros = 0;
        
        for(int end = 0 ; end < nums.length; end++){
            
            if(nums[end] == 0) countOfZeros++;
            
            while(countOfZeros > k){
                if(nums[start++] == 0)
                    countOfZeros--;
            }
            
            res = Math.max(res, end-start+1);
        }
        return res;
    }
}
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int rSum = 0;
        int start = 0;
        Double res = -Double.MAX_VALUE; // In java -Double.MaxValue is the lowest double value** 
        for(int end = 0; end < nums.length; end++){
            
            rSum += nums[end];
            
            while(end - start + 1 > k && start < end){
                rSum -= nums[start];
                start++;
            }
            
           if(end - start +1 == k)
                res = Math.max(res, rSum);
            
        }
        return (res * 1.0 )/ k;
    }
}

 
//time complexity : O(n^2)
//space complexity : O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int output[] = new int[nums.length];
        Arrays.fill(output,1);
        int maxLength = 0; 
        for(int i = 0 ; i < nums.length; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j])
                    output[i] = Math.max(output[i], 1 + output[j]);
            }    
            maxLength = Math.max(output[i],maxLength);
        }
        return maxLength;
    }
}
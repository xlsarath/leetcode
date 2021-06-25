//time complexity : O(n^2)
//space complexity : O(1)
//leet code : yes
//steps : DP approach


public class LongestIncreasingSubSequence300 {

        public int lengthOfLIS(int[] nums) {
            
            int n = nums.length;
            
            int output[] = new int[n];
            int maxLength = 0;
            
            Arrays.fill(output, 1);
            
            for(int i = 0; i < n ; i++){
                for(int j = i-1; j >= 0; j--){
                        if(nums[i] > nums[j]){
                            output[i] = Math.max(output[i], 1 + output[j]);
                        }
                }
                maxLength = Math.max(maxLength, output[i]);
            }
            return maxLength;
        }
    }
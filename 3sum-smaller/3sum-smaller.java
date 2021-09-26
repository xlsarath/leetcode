class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        if(nums == null || nums.length < 3) return 0;
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length -2; i++){
            //if( i > 0 && nums[i] == nums[i-1]) continue;
           
            int low = i+1;
            int high = nums.length - 1;
            
            while(low < high){
                
                int sum = nums[i] + nums[low] + nums[high];
                if(sum < target){
                    result += high - low;
                    low++;
                } else
                    high--;
            }
            
            
        }
     return result;   
    }   
}



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //base 
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length - 2; i++){
            
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int low = i+1;
            int high = nums.length - 1;
            
            while(low < high){
                
                
                int sum = nums[i]+nums[low]+nums[high];
                //base
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[low], nums[high]));
                    low++;
                    high--;
                    
                    //duplicates
                    while(low < high && nums[low] == nums[low-1]) low++;
                    while(high > low && nums[high] == nums[high+1]) high--;
                } else if(sum < 0)
                    low++;
                else 
                    high--;
            }
            
        }
        return result;
    }
}
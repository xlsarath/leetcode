class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        if(nums == null || nums.length < 4) return new ArrayList<>();
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length -3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length - 2; j++){
                    if(j > i+1 && nums[j] == nums[j-1]) continue;
                    pairSum(j+1, nums.length - 1, target - (nums[i]+nums[j]), i, j, nums, result);
            }
            
        }
        return result;
    }
    
    public void pairSum(int low, int high, int target, int i, int j, int nums[], List<List<Integer>> result){
        
        while(low < high){
            
            int sum = nums[low]+nums[high];
            //base
            if(sum == target){
                result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                low++;
                high--;
                
                while(low < high && nums[low] == nums[low-1]) low++;
                while(high > low && nums[high] == nums[high+1]) high--;
                
            } else if(sum > target)
                high--;
            else
                low++;
        }
        
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        //[-1,0,1,2,-1,-4]
        Arrays.sort(nums);
        //[-4,-1,-1,0,1,2]
        //     i.   L  h
        for(int i = 0 ; i < nums.length -2; i++){
            
            int low = i+1;
            int high = nums.length -1;
            
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            while( low < high){
                
                int sum = nums[i] + nums[low] + nums [high];
                
                if(sum == 0){
                    
                    res.add(Arrays.asList(nums[i],nums[low], nums[high]));
                    low++;
                    high--;
                    
                 while( low < high && nums[low] == nums[low-1]) low++;
                 while(low < high && nums[high] == nums[high + 1]) high--;   
                }
                else if (sum > 0) high--;
                else low++;
            }
            
        }
        return res;
    }
}
class Solution {
    
    /**
    public boolean canJump(int[] nums) {
     return  backTrack(nums, 0);
    }
    
    
    public boolean backTrack(int[] nums, int idx){
        
        //base
        if(idx == nums.length - 1) {
            return true;
        }
        
        int furthestJump = Math.min(idx + nums[idx] , nums.length - 1);
        for(int nextPos = idx + 1; nextPos <= furthestJump; nextPos++){
            if(backTrack(nums, nextPos))
                return true;
        }
        
    
    }
    */
    
    
    public boolean canJump(int[] nums){
        
        
        if(nums == null || nums.length < 2) return true;
        
        int destination = nums.length - 1;
        
        for(int i = destination; i >= 0; i--)
            if(i + nums[i] >= destination)
                    destination = i;
    
         return destination == 0;   
        }
}
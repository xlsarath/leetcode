class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length == 0) return 0; 
        
        int nextNonDuplicate = 1;
                    
        for(int  i = 1 ; i < nums.length; i++ ){
            
            //postive case
            if(nums[nextNonDuplicate - 1] != nums[i]){
                nums[nextNonDuplicate] = nums[i];
                nextNonDuplicate++;
            }
    
        }
        return nextNonDuplicate;
    }
}
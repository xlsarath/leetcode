class Solution {
    public int[] sortedSquares(int[] nums) {
        
        
        int res[] = new int[nums.length];
        int low = 0, high = nums.length - 1;
        for(int i = nums.length - 1; i >= 0 ; i--){
            int square = Math.max(Math.abs(nums[low]),Math.abs(nums[high]));
            
            if(Math.abs(nums[high]) > Math.abs(nums[low]))
                high--;
            else 
                low++;
            
            res[i] = square * square;
        }
        
        return res;
    }
}
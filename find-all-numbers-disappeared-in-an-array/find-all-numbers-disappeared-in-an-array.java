class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        /**
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        
        List<Integer> res = new ArrayList<>();
        for(int i = 1 ; i <= nums.length; i++){
            if(!set.contains(i))
                res.add(i);
        }
        return res;
        */
        
         List<Integer> result = new ArrayList<>();
        
        for(int i =0 ;i <nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = -1 * nums[index];
            }
        }
        
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        
        return result;
        
            
    }
}

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        Arrays.sort(nums);
        
        backTrack(nums, result, 0, new ArrayList<>());
    
        return result;    
    }
    
    public void backTrack(int[] nums, List<List<Integer>> result, int idx, List<Integer> state){
        
    
            result.add(new ArrayList<>(state));
        
        
        
        for(int i = idx; i < nums.length; i++){            
            if(i != idx && nums[i] == nums[i-1]) 
                continue; // i != idx is imp
            state.add(nums[i]);
            backTrack(nums, result, i+1, state);
            state.remove(state.size()-1);
        }
        
    }
}
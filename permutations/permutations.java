class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
      List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
      backTrack(nums, result, new ArrayList<>(), 0);
      return result;  
    }
    
    public void backTrack(int nums[], List<List<Integer>> result, List<Integer> state, int idx){
        
        if(state.size() == nums.length){
            result.add(new ArrayList<>(state));
            return;
        }
            
        
        for(int i = 0; i < nums.length; i++){
            if(state.contains(nums[i])) continue;
            state.add(nums[i]);
            backTrack(nums, result, state, i);
            state.remove(state.size()-1);
        }
    }
}
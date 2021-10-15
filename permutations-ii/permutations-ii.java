class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        boolean visited[] = new boolean[nums.length];
        backTrack(nums, result, new ArrayList<>(), visited);
        
        return result;
    }
    
    public void backTrack(int[] nums, List<List<Integer>> result, List<Integer> state, boolean visited[]){
        
        if(state.size() == nums.length){
            result.add(new ArrayList<>(state));
            return;
        }
        
        for(int i = 0 ; i < nums.length; i++){
            if((visited[i]) || (i != 0 && visited[i-1] && nums[i] == nums[i-1])) 
                continue;
            state.add(nums[i]);
            visited[i] = true;
            backTrack(nums, result, state, visited);
            visited[i] = false;
            state.remove(state.size()-1);
        }
    }
}
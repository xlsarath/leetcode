class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        backTracking(candidates, result, new ArrayList<>(), 0, 0, target);
        
        return result;
    }
    
    public void backTracking(int[] candidates, List<List<Integer>> result, List<Integer> state, int sum, int idx, int target){
        
        if(sum > target) return;
        
        if(sum == target){
            result.add(new ArrayList<>(state));
        }
        
        
        
        for(int i = idx; i < candidates.length; i++){
            state.add(candidates[i]);
            backTracking(candidates, result, state, sum + candidates[i], i, target);
            state.remove(state.size() - 1);
        }
        
    }
    
}
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        backTrack(candidates, target, result, new ArrayList<>(), 0, 0);
        
        return result;
    }
    
    public void backTrack(int[] candidates, int target,List<List<Integer>> result, List<Integer> state, int idx, int sum ){
        
        if(sum == target){
            result.add(new ArrayList<>(state));
            return;
        }
        
        if(sum > target) return;
        
        for(int i = idx; i < candidates.length; i++){
            state.add(candidates[i]);
            backTrack(candidates, target, result, state, i, candidates[i] + sum);
            state.remove(state.size()-1);
        }
        
    }
    
}
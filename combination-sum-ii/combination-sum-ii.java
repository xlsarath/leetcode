class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        
        Arrays.sort(candidates);
        
        backTrack(candidates, target, result, new ArrayList<>(), 0, 0);
        
        return result;
    }
    
    public void backTrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> state, int idx, int rSum){
        
        if(rSum == target){
            result.add(new ArrayList<>(state));
            return;
        }
        
        if(rSum > target) return;
        
        for(int i = idx; i < candidates.length; i++){
            if( i != idx && candidates[i] == candidates[i-1]) continue;
            state.add(candidates[i]);
            backTrack(candidates, target, result, state, i+1, rSum+candidates[i]);
            state.remove(state.size()-1);
        }
    }
}
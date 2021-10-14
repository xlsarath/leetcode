/**
time complexity for both BFS and BackTracking is O(N*2^N)
space complexity : O(N)
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        
        backTrack(nums, result, 0, new ArrayList<>());
        
        return result;
    }
    
    public void backTrack(int[] nums, List<List<Integer>> result, int idx, List<Integer> state){
        
      
            result.add(new ArrayList<>(state));
        
        
        for(int i = idx ; i < nums.length; i++){
            state.add(nums[i]);
            backTrack(nums, result, i+1, state);
            state.remove(state.size() - 1);
        }
    }
}
/**
public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null) return list;
        
        list.add(new ArrayList<>());
        
        for(int i = 0; i < nums.length; i++){
            int size = list.size();
            for(int j = 0 ; j < size; j++){
                List<Integer> temp = new ArrayList<>(list.get(j));
                temp.add(nums[i]);
                list.add(temp);
            }
        }
        
        return list;
    }
*/

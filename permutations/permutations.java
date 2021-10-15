//time comeplexity : worst case N*N!
//space complexity : O(N!)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>());
        
        for(int i = 0 ; i < nums.length; i++){
            int size = q.size();
            for(int j = 0 ; j <size; j++){
              List<Integer> prevList = q.poll();
                for(int k = 0 ; k <= prevList.size(); k++){
                    List<Integer> temp = new ArrayList<>(prevList);
                    temp.add(k,nums[i]);  
                    q.add(temp);  
                }
            }
        }
        
        while(!q.isEmpty())
            result.add(q.poll());
        
      return result;  
    }
}

/**

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
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
         
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        Arrays.sort(nums);
        
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>());
        
        for(int i = 0; i < nums.length; i++){
            int size = q.size();
            for(int j = 0 ; j < size; j++){
                List<Integer> temp = q.poll();
                for(int k = 0 ; k <= temp.size(); k++){
                    if( k != 0 && temp.get(k-1) == nums[i] ) break; 
                    List<Integer> subList = new ArrayList<>(temp);
                    subList.add(k,nums[i]);
                    q.offer(subList);
                }
            }
            
        }
        
       
        
        return new ArrayList<>(q);
    }
}

/**

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
*/
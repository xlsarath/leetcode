/** [1,2,2]
// []
// [] [1]
// [] [1] [2] [1 2]
//.duplicate found, copy lists from [2] , skip prev list
// [] [1] [2] [1 2] [2 2] [1 2 2]

Time complexity : O(n*2^n)
Space complexity : O(n)

**/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        Arrays.sort(nums);
        result.add(new ArrayList<>());
         int size = 0;
        for(int i = 0 ; i < nums.length; i++){
            
            int end = 0;
            if( i != 0 && nums[i] == nums[i-1])    
                    end = size;
            size = result.size();
            for(int j = end ; j < size; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        
        return result;
    }
}

/**
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
*/

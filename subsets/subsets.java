class Solution {
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
}
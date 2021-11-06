class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
         HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();       
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i = 0;i<groupSizes.length;i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(groupSizes[i])) {
                list = map.get(groupSizes[i]);   
            }
            list.add(i);
            if(list.size() == groupSizes[i]) {
                ans.add(list);
                list = new ArrayList<Integer>();
            }
            map.put(groupSizes[i],list);
        }
        return ans; 
    }
}
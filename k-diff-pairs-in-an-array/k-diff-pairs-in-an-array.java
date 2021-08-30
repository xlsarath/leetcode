//time complexity : O(n)
//space complexity : O(n)
class Solution {
    public int findPairs(int[] nums, int k) {
        
         int result = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int n : nums) map.put(n, map.getOrDefault(n,0)+1);
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if( k > 0 && map.containsKey(key + k)) result++;
            else if(k == 0 && val > 1) result++; 
        }
      return result;
        /**
        
        // time complexity : nlogn
//space complexity : 2*n
        if( k < 0) return 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++)
                map.put(nums[i], i );
        
        HashSet<List<Integer>> set = new HashSet<>();
        
        for(int i = 0 ; i < nums.length; i++){
            
            
            int compliment1 = nums[i] - k;
            int compliment2 = nums[i] + k;
            
            if(map.containsKey(compliment1)){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(compliment1);
                Collections.sort(temp);
                if(!set.contains(temp) && map.get(compliment1) != i)
                    set.add(temp);
            }
            if(map.containsKey(compliment2)){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(compliment2);
                Collections.sort(temp);
                if(!set.contains(temp) && map.get(compliment2) != i)
                    set.add(temp);
            }        
        }
        
        return set.size();
        */
    }
}

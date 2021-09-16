//time complexity : O(n)
//space complexity : O(1)
class Solution {
        
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums) set.add(n);
        
        int max = 0;
        for(int n : set){
            
            if(!set.contains(n-1)){
                int m = n + 1;
                while(set.contains(m)) m++;
                max = Math.max(max, m - n);
            }
                
        }
        return max;
    }
}



 
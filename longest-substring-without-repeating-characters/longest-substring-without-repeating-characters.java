class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0) return 0;
        
        HashSet<Character> set = new HashSet<>();
        
        int start = 0, end = 0, max = Integer.MIN_VALUE;
        
        while(end < s.length()){
            while(set.contains(s.charAt(end)))
                set.remove(s.charAt(start++));
            
            set.add(s.charAt(end));
            max = Math.max(max, (end-start)+1);
            end++;
        }
        return max;
    }
}
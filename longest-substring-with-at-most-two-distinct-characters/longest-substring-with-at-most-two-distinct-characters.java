class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        HashMap<Character,Integer> charFreqMap = new HashMap<>();
        
        int start = 0; int res = 0;
        for(int end = 0 ; end < s.length(); end++){
            
            charFreqMap.put(s.charAt(end), charFreqMap.getOrDefault(s.charAt(end),0)+1);
            
            while(charFreqMap.size() > 2){
                int val = charFreqMap.get(s.charAt(start));
                if (val - 1 == 0) 
                    charFreqMap.remove(s.charAt(start)) ;
                else
                    charFreqMap.put(s.charAt(start), val -1);
                start++;
            }
            
            res = Math.max(end-start+1, res);
            
        }
        return res;
    }
}
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        HashMap<Character,Integer> charFreq = new HashMap<>();
        
        int start = 0;
        int res = 0;
        for(int end = 0 ; end < s.length(); end++){
            
            charFreq.put(s.charAt(end), charFreq.getOrDefault(s.charAt(end), 0)+1);
            
            while(charFreq.size() > k){
                int val = charFreq.get(s.charAt(start));
                if(val - 1 == 0)
                    charFreq.remove(s.charAt(start));
                else
                    charFreq.put(s.charAt(start), val -1);
                
                start++;
            }
            
            //if(charFreq.size() == k)
                res = Math.max(res, end - start+1);
            
        }
        return res;
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        
        int pFreq[] = new int[26];
        for(char ch : p.toCharArray()) pFreq[ch - 'a']++;
        
        int start = 0;
        int sFreq[] = new int[26];
        
        for(int end = 0 ; end < s.length(); end++){
            
                sFreq[s.charAt(end) - 'a']++;
            
            
               if(end >= p.length()){
                   sFreq[s.charAt(start)-'a']--;
                   start++;
               }
            
            if(Arrays.equals(pFreq,sFreq))
                res.add(end - p.length() + 1);
            
            
        }
        
        return res;
        
    }
}
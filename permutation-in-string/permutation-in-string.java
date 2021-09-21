class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int s1Freq[] = new int[26];
            for(char ch : s1.toCharArray()) s1Freq[ch-'a']++;
        
        int s2Freq[] = new int[26];
        
        for(int end = 0; end < s2.length(); end++){
             
            s2Freq[s2.charAt(end) - 'a']++;
            
            if(end >= s1.length()){
                s2Freq[s2.charAt(end - s1.length()) - 'a']--;
            }
            
            if(Arrays.equals(s1Freq,s2Freq)) return true;
            
        }
            
         return false;   
        
    }
}
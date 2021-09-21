class Solution {
    public int characterReplacement(String s, int k) {
       
        int start = 0;
        int count[] = new int[26];
        int res = 0;
        int mostFreqChar = 0;
        for(int end = 0; end < s.length() ; end++){
                    
            count[s.charAt(end) -'A']++; 
            mostFreqChar = Math.max(mostFreqChar,count[s.charAt(end) -'A']);
            
            //increment start 
            while(end-start+1-mostFreqChar > k ){
                count[s.charAt(start) -'A']--; 
                start++;
            }
            
            //when to add res
            res = Math.max(res,end-start+1);
        }
      
        return res;
        
        
    }
}
//time complexity : O(N^2)
//space complexity : O(1)

class Solution {
    public int countSubstrings(String s) {
        
        if(s.length() == 0) return 0;
      
        int result = 0;
        for(int i =  0; i < s.length(); i++){
            result += extendPalindrome(s, i, i); // odd length
            result += extendPalindrome(s, i, i+1); //even length
        }
        return result;
    }
    
    public int extendPalindrome(String s, int start, int end){
        int count = 0;
        while( start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            count++;
        }
        return count;
    }
}


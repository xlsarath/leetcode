class Solution {
    public boolean validPalindrome(String s) {
        
        int start = 0, end = s.length()- 1;
        
        while(start < end){
            
            if(s.charAt(start) != s.charAt(end)){
                
                return (isPalindrome(start+1, end, s)) || (isPalindrome(start, end-1, s));
                
            }
            start++;
            end--;
        }
        return true;
    }
    
    public boolean isPalindrome(int i, int j, String s){
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
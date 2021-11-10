class Solution {
    public int strStr(String haystack, String needle) {
        
        if(haystack.length() >= 0  && needle.length() == 0) return 0;        
        if(needle.length() > haystack.length()) return -1;
        
        int k = 0;
        int len = needle.length();
        for(int i = 0 ; i < haystack.length(); i++){
            
            if(haystack.charAt(i) == needle.charAt(0)){
                if( i + len <= haystack.length()){
                    k = 0;
                    for(int j = i; j < i+len; j++){
                        if(haystack.charAt(j) == needle.charAt(k)){
                            k++;
                        } else {
                            break;
                        }
                    }
                    if(k == len) return i;
                }
            }
        }
        
            return -1;
        
    }
}
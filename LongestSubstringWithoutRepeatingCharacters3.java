import java.util.HashSet;
import java.util.Set;
//time complexity : O(n)
//space compplexity : O(n) ..size of given string
//leet code : yes
//steps : used sliding window technique.
class LongestSubstringWithoutRepeatingCharacters3 {
    
        public int lengthOfLongestSubstring(String s) {
    
            if(s==null) return 0;
            int start=0,end=0,max =0;
            Set<Character> set = new HashSet<>();
            
            while(end<s.length()){
                while(set.contains(s.charAt(end))){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(s.charAt(end));
                max = Math.max(max,end-start+1);
                end++;
            }
            
            return max;
            
        }
    
}
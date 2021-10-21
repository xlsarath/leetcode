class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Character> sMap = new HashMap<>();
        HashMap<Character,Character> tMap = new HashMap<>();
        
        if(s.length() != t.length()) return false;
        
        for(int i = 0 ; i < t.length(); i++){
            
            char tChar = t.charAt(i);
            char sChar = s.charAt(i);
            
            tMap.putIfAbsent(tChar,sChar);
            if(tMap.get(tChar) != sChar) return false;
            
            sMap.putIfAbsent(sChar,tChar);
            if(sMap.get(sChar) != tChar) return false;
            
        }
        return true;
    }
}
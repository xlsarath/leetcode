/**
 * time complexity : O(k) k-is length of max string
 * spaace complexity : O(1);
 * leetcode execution : successfull
 * Steps: 1) break string to chars, imply s1.char as key and add s2.char into hashmap1. Once done reversemap from s2.char to s1.char in hashmap2.
 *        2) check for match condition if mapping for s1.char<==>s2.char. if mapping fails..it's not isomorphic.
 *        3) Once loop itereated successfully for entire string length, if no false encountered then it's isomorphic.
 */

import java.util.HashMap;

class IsomorphicHM205{

    public boolean isIsomorphic(String S,String T){

        if(S.length()!=T.length()) {return false;}
        
        HashMap<Character,Character> stMap = new HashMap<>();
        HashMap<Character,Character> tsMap = new HashMap<>();

        for(int i=0; i<S.length();i++){
            Character s,t;
            s=S.charAt(i);
            t=T.charAt(i);

            //sMap
            if(!stMap.containsKey(s)){
                stMap.put(s,t);
            }
            else {
                if(t!=stMap.get(s)) return false;
            }
            //tMap
            if(!tsMap.containsKey(t)){
                tsMap.put(t,s);
            }
            else {
                if(s!=tsMap.get(t)) return false;
            }

        }
        return true;
    
    }



    public static void main(String[] args) {
        IsomorphicHM205 hm = new IsomorphicHM205();
        System.out.println(hm.isIsomorphic("eat", "tea"));
        System.out.println(hm.isIsomorphic("eat", "tear"));

    }
}
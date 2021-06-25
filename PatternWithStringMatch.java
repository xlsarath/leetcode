/**
 * time complexity :  O(k), in worst case it'll be length of pattern.
 * Space complexity : O(1)
 * LeetCode : i couldn't find it on leet code. 
 * steps: 1) split string into chars and store char with each word of string
 *          2) while doing check if new word matches with existing word in hashMap. If it doesn't stop loop and return false.
 * 
 */
import java.util.HashMap;

class PatternWithStringMatch{

    public boolean patternMatch(String pattern, String[] input){
        
        if(pattern.length()!=input.length){return false;}
        HashMap<Character,String> map = new HashMap<>();
        for(int i = 0; i<pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i), input[i]);
            }
            else {
                if(!input[i].equals(map.get(pattern.charAt(i)))){
                    return false;
                }
            }
        }
        return true;
    }




    public static void main(String[] args) {

        PatternWithStringMatch pt = new PatternWithStringMatch();
        String [] input = {"cat","cat","dog","cat"};
        System.out.println(pt.patternMatch("aaba", input));
        
    }
}
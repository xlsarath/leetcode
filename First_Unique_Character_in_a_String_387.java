import java.util.*;

//time complexity : O(N) and space (O(N))

class First_Unique_Character_in_a_String_387{

    public static int firstUniqChar(String s) {
        
        
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0) +1);
            
        for(int i = 0 ; i < s.length() ; i++)
        {
           if(map.get(s.charAt(i)) == 1) return i;
        }
        
        
        return -1;
        
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("hhello"));
    }

}
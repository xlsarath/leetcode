import java.util.*;
/**
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false
 
 * 
 */
public class StrobogrammaticNumber{

    public static boolean isStrobogrammaticHashMap(String num){
        if(num == null || num.length() == 0 ) return false;
        
        HashMap<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('8','8');
        map.put('1','1');
        map.put('6','9');
        map.put('9','6');
        
        int low = 0; int high =num.length() - 1;
        
        while(low <= high){
            
            char first = num.charAt(low);
            char last  = num.charAt(high);
            
            if(map.containsKey(first) && map.containsKey(last) && map.get(first) != last)
             return false;
            else
              {
                  low++;
                  high--;
              }
            
        }
        
        return true;
    }

    public static boolean isStrobogrammaticTwoPointer(String num){

            //base check

            if(num == null || num.length() == 0 ) return false;
            
            int low = 0;
            int high = num.length() - 1;

            while(low <= high){

                if(num.charAt(low) == num.charAt(high)){
                    if(num.charAt(low) != '1' && num.charAt(low) != '0' && num.charAt(low)  != '8')
                        return false;
                } else {
                    if((num.charAt(low) != '6' || num.charAt(high) != '9') && (num.charAt(low) != '9' || num.charAt(high) != '6'))
                        return false;
                }
                low++; high--;
            }
        return true;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber numm = new StrobogrammaticNumber();
        System.out.println(numm.isStrobogrammaticTwoPointer("808"));
        
    }


}
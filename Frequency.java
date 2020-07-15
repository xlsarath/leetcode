
import java.io.*;
import java.util.*;


/*

For a given string "abbbcddddeffabbbbbb" return the characters who are consecutively repeated like "bbb" and how many times it appears on the string.
For example, return a HashMap like,
b -> 2 Note: (bbb & bbbbbb)
d -> 1
f -> 1
Note: “a” appears two times but it is not consecutively repeated so it is not included. The same is true for “e”.

*/
class Frequency
{
  public static void main(String[] args) {
  System.out.println(getMapping("ababcddddeffaabbbbbbegiuooyyyyoobbbbb"));

}
  public static Map<Character , Integer> getMapping(String str) {
    
        
    HashMap<Character,Integer> map = new HashMap<>();
    
    char preVal = str.charAt(0);
      
   

    int counter =0 ;
    for(int i=1; i < str.length(); i++){
          
         char ch = str.charAt(i);
      
        if(ch == preVal) {          
              counter++; 
        } else if (ch != preVal && counter>=1){
             validate(map,preVal);
             counter = 0;
        } 
      preVal = ch;
    }
    validate(map,preVal);   
    return map;

  }


  public static void validate(Map<Character , Integer> map, char preVal){
    if(map.containsKey(preVal)) {
        int v = map.get(preVal);
        v++;
      map.put(preVal,v);
    } else {map.put(preVal,1);}

  }
}



































/*
Given an array of integers, return an list of integers which contains
[1st integer, Sum of next 2 integers (2nd, 3rd), Sum of next 3 integers (4th, 5th, 6th)…] and so on

Input 
[1,6,8,5,9,4,7,2]
Output 
[1,14,18,9]
 */

// class Solution {
//    public static void main(String[] args){
//         System.out.println(summation(new int[]{1,6,8,5,9,4,7,2}));
//     }
  
  
//     private static List<Integer> summation(int[] arr){
    
      
//       //base 
      
//       if(arr.length ==0 || arr==null) return new ArrayList<>();
      
      
//       List<Integer> result = new ArrayList<Integer>();
//       int level = 0;
//       for(int i = 0; i < arr.length; i++){
          
//               int rSum = 0;
//             for(int j =0 ; j<level; j++){
//                 if(i+j < arr.length)
//                   rSum = rSum + arr[i+j];
                
//             }
//         level++;
//         result.add(rSum);
//       }
      
     
//       int leftOver = arr.length%level,finSum = 0;
      
//       for(int i = arr.length-1; i>=leftOver; i--){
        
//         finSum += arr[i];
      
//       }
//       result.add(finSum);
      
//       return result;
//     }
// }



class Frequency {

}
import java.util.*;
// time complexity :  O(n)
// space complexity : O(1)


public class SubStringLessKDist {

   
    public List<String> subStringMethod(String inputString, int num){
        
        //base
        if(inputString == null || inputString.length() == 0) return new ArrayList<>();
        
        Set<String> set = new HashSet<>();
        int frequencyCh[] = new int[26];
        int distinctChars = 0;
        int i = 0;
        for(; i < num; i++){
            if(frequencyCh[inputString.charAt(i) - 'a'] == 0) distinctChars++;
            frequencyCh[inputString.charAt(i) - 'a']++;
        }

        if(distinctChars == num) set.add(inputString.substring(i-num,i));  // is its k -1 ..add prefix k-1
        
        while( i < inputString.length()){
            if(frequencyCh[inputString.charAt(i) - 'a'] == 0) distinctChars++;
            frequencyCh[inputString.charAt(i) - 'a']++;
            frequencyCh[inputString.charAt(i-num) - 'a']--;
            if(frequencyCh[inputString.charAt(i-num) - 'a'] == 0) distinctChars--;
            if(distinctChars == num) set.add(inputString.substring(i-num+1,i+1));   // is its k -1 ..add prefix k-1
            i++;
        }
        return new ArrayList<>(set);
        }


    public static void main(String[] args) {
        for(String s : new SubStringLessKDist().subStringMethod("abacab",3))
        System.out.println(s);                
    }

}
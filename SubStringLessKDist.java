import java.util.*;
// time complexity :  O(n)
// space complexity : O()


public class SubStringLessKDist {

    public List<String> subStringMethod(String inputString, int num){


        //base
        if(inputString.length() == 0 || inputString == null) return new ArrayList<>();

        int distinct = 0;
        int chars[] = new int[26];
        Set<String> set = new HashSet<>();
        int i = 0;
        for(; i < inputString.length(); i++){
            if(chars[inputString.charAt(i) - 'a'] == 0)
                distinct += 1;
            chars[inputString.charAt(i) - 'a'] += 1;
        }

            if(distinct == num -1 )
                set.add(inputString.substring(i-num, i));
            
        
            while(i < inputString.length()){
                if(chars[inputString.charAt(i) - 'a'] == 0)
                        distinct += 1;
                chars[inputString.charAt(i) - 'a'] += 1;
                chars[inputString.charAt(i) - 'a'] -= 1;
                if(chars[inputString.charAt(i) - 'a'] == 0)
                    distinct += 1;
                if(distinct == num -1)
                    set.add(inputString.substring(i-num+1,i+1));
                i++;
            }

            return new ArrayList<>(set);
        }


    public static void main(String[] args) {
        System.out.println(new SubStringLessKDist().subStringMethod("awaglknagawunagwkwagl", 4));
                
    }

}
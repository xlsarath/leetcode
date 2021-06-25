import java.util.*;


public class Two_Characters_hackerRank {


        static int alternate_Optimal(String str){

                int pairs[][] = new int[26][26];
                int count[][] = new int[26][26];

                for(int i = 0; i < str.length(); i++){

                    char letter = str.charAt(i);
                    int letterNum = letter - 'a';

                //    System.out.println(Arrays.deepToString(pairs));
                  //  System.out.println(Arrays.deepToString(count));

                    //row
                    for(int col = 0 ; col < 26; col++){
                        if(pairs[letterNum][col] == letter){
                            count[letterNum][col] = -1;
                        }

                        if(pairs[letterNum][col] != -1){
                            pairs[letterNum][col] = letter;
                            count[letterNum][col]++;
                        }


                    }


                    //col
                    for(int row = 0; row < 26; row++){
                        if(pairs[row][letterNum] == letter){
                            count[row][letterNum] = -1;
                        }
                        if(pairs[row][letterNum] != -1){
                            pairs[row][letterNum] = letter;
                            count[row][letterNum]++;
                        }
                    }
                }
              //  System.out.println(Arrays.deepToString(pairs));
               // System.out.println(Arrays.deepToString(count));

                int counts = 0 ;

                for(int i = 0 ; i < 26; i++){
                    for(int j = 0 ; j < 26; j++){
                        counts = Math.max(counts,count[i][j]);
                    }
                }
                return counts;

        }




        static int alternate(String s) {
            
            int count = 0;
            Set<Character> set = new HashSet();
            for(char c : s.toCharArray()) set.add(c);
            int current = 0;
            List<Character> list = new ArrayList(set);
            while(current < list.size()){
                    String temp = ""+list.get(current); 
                    String toReplace = s.replaceAll(temp, "");
                    count = Math.max(count, findMatch(toReplace));
                    for(int i = current; i < list.size(); i++){
                        toReplace  = toReplace.replaceAll(list.get(i)+"", "");
                        count = Math.max(count, findMatch(toReplace));
                    }
                    current++;
                }
            
            return count;
    
        }
        
        static int findMatch(String str){
            Set<Character> set = new HashSet<>();
            for(char c : str.toCharArray()) set.add(c);
            if(set.size() == 2) {
                char c = str.charAt(0);
                for(int i = 1; i < str.length(); i++){
                    if(str.charAt(i) == c) return 0;
                    else c = str.charAt(i);
                }
            } else return 0;
            return str.length();            
        }

public static void main(String[] args) {
    System.out.println(Two_Characters_hackerRank.alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
    System.out.println(Two_Characters_hackerRank.alternate_Optimal("beabeefeab"));

}

    }
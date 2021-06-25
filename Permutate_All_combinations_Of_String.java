import java.util.*;

//time complexity : O(n * n!)

public class Permutate_All_combinations_Of_String {

    public static List<String> getAllPermutations(String str){

        List<String> result = new ArrayList<>();

        dfs(result, str, 0 , str.length()-1);

        return result;

    }

    private  static void dfs(List<String> result, String str, int i, int j) {
        
        if( i == j) result.add(str);
        else {

            for(int k = i; k <= j; k++){
                str = Swap(str,i,k);
                dfs(result,str,i+1, j);
            }
        }

    }

    private static String Swap(String str, int i, int k) {

        char temp;
        char []charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[k];
        charArray[k] = temp;


        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        System.out.println(getAllPermutations("ABCDE"));
    }

}
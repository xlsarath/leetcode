import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//time complexity : O(n^n)
//space complexity : O(n)
//steps : implemeted using DP;
//leet code :yes


public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();
        for(String word: wordDict){
            set.add(word);
        }

        s = '^'+s;
        boolean isValid[] = new boolean[s.length()];
        isValid[0]=true;

        for(int i=1; i<s.length(); i++){
            int k =i;
            while(k>=1){
                if(set.contains(s.substring(k,i+1)) && isValid[k-1]){
                    isValid[i]=true;
                    break;
                }
                k--;
            }
        }
        for(boolean bool:isValid)
    System.out.println(bool);
    return isValid[s.length()-1];
    }

    public static void main(String[] args) {
        WordBreak139 wb = new WordBreak139();
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(wb.wordBreak("catsandog",list));
    }

}
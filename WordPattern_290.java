import java.util.*;

public class WordPattern_290 {
        public static boolean wordPattern(String pattern, String s) {
            
            
           String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        HashMap<Object,Object> index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
        }
    

        public static void main(String[] args) {

            System.out.println(wordPattern("abba", "dog cat cat dog"));
            System.out.println(wordPattern("abba", "dog cat cat fish"));
            System.out.println(wordPattern("aaaa", "dog cat cat dog"));
            System.out.println(wordPattern("abba", "ddog dog dog dog"));

        }
}

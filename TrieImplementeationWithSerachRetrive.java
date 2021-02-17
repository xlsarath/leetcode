import java.util.*;

public class TrieImplementeationWithSerachRetrive {
    

    TrieNode root;

    TrieImplementeationWithSerachRetrive(){
            
        root = new TrieNode();

    }

    public void insert(String word){
        TrieNode cursor = root;
        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
                if(cursor.childern[ch-'a'] == null)
                    cursor.childern[ch-'a'] = new TrieNode(); 
             cursor = cursor.childern[ch-'a'];       
        }
        cursor.isWord = true;
    }


    public boolean searchPrefix(String word){
        TrieNode cursor = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cursor.childern[ch-'a'] == null)
                return false;
            cursor  = cursor.childern[ch-'a'];    
        }
        return true;
    }

    public boolean searchWord(String word){
        TrieNode cursor = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cursor.childern[ch-'a'] == null)
                return false;
            cursor  = cursor.childern[ch-'a'];    
        }
        return cursor.isWord;
    }

    public PriorityQueue<String> getAllWordsMatchingPrefix(String word, int k){
        TrieNode cursor = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cursor.childern[ch-'a'] == null)
                return new PriorityQueue<>();
            cursor  = cursor.childern[ch-'a'];    
        }

        PriorityQueue<String> result = new PriorityQueue<>(
            (a,b) -> b.compareTo(a)
        );
        dfs(result, cursor, new StringBuilder(), word, k);

        return result;
    }



    private void dfs(PriorityQueue<String> result, TrieNode cursor, StringBuilder sb, String word, int k) {

        if(cursor.isWord) 
        { 
            result.add(word+""+sb.toString());
            if(result.size() > k)
                result.poll();
            return;
        }


        for(int i = 0 ; i < 26; i++){
            if(cursor.childern[i] != null){
               char b = (char) (i+'a');
               sb.append(b);
               dfs(result, cursor.childern[i] , sb, word, k);
               sb.deleteCharAt(sb.length() - 1);            
            }
        }

    }

    class TrieNode {
        TrieNode[] childern;
        boolean isWord;
        TrieNode(){
            childern = new TrieNode[26];
        }
    }

    public static void main(String[] args){
        
        TrieImplementeationWithSerachRetrive a = new TrieImplementeationWithSerachRetrive();
        a.insert("sam");
        a.insert("sap");
        a.insert("sling");
        a.insert("ramp");
        a.insert("catch");
        a.insert("bus");
        a.insert("car");
        a.insert("cast");
        System.out.println(a.getAllWordsMatchingPrefix("c",2));
        

    }
}

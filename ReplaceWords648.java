import java.util.LinkedList;
import java.util.List;
//time complexity :  O(KN), k is max size of word in dict for insertion and N is max length of sentence
//space complexity : O(K) height of trie
//leet code : yes
//steps: dictonary is inserted into trie. followed by each word of sentence is splitted into it's individual char verified against trie for the availability. If any word exists return word from dictonary else same word of sentence is returnd. 


class ReplaceWords648 {

    /**
     * 
         Input: dict = ["cat", "bat", "rat"]
        sentence = "the cattle was rattled by the battery"
        Output: "the cat was rat by the bat"
     */

    public String replaceWords(List<String> dict, String sentence) {
        ImplementTrie trie = new ImplementTrie();

        for (String word : dict){
            trie.insert(word);
        }

        String words[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            sb.append(trie.search(words[i]));
            if(i<words.length-1)
                sb.append(" ");
        }
        return sb.toString();
        }

    


    class ImplementTrie{
        TrieNode root;
    
        ImplementTrie(){
            root = new TrieNode();
        }
    
        public void insert(String word) {
            TrieNode cursor = root;
    
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(cursor.childern[ch-'a']==null){
                    cursor.childern[ch-'a'] = new TrieNode();
                }
                cursor = cursor.childern[ch-'a'];
            }
        cursor.isEndOfWord = true;
        }
    
        public String search(String word){
            StringBuilder sb = new StringBuilder();
            TrieNode cursor = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(cursor.isEndOfWord){
                    return sb.toString();
                }
               else if(cursor.childern[ch-'a']!=null){
                    sb.append(ch);
                }
                
                else if(cursor.childern[ch-'a']==null){
                    return word;
                }
                cursor = cursor.childern[ch-'a'];
            }
            return word;
        }
        
    
       
    
    
        public class TrieNode {
            TrieNode[] childern;
            boolean isEndOfWord;
        
            TrieNode(){
                childern = new TrieNode[26];
            }
        }
    

   
   
    }


    public static void main(String[] args) {
        ReplaceWords648 rp = new ReplaceWords648();
 
        List<String> dict = new LinkedList<>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
 
        System.out.println(rp.replaceWords(dict, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }
}
    
    

   


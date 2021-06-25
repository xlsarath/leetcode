//time complexity : O(n) <-- to add word ; O(k) <-- k is height of trie
// space complexity : O(n)
public class Design_Add_and_Search_Words_Data_Structure_211 {


    public class TrieNode{

        TrieNode childern[] = new TrieNode[26];
        boolean isWord;
    }

    public TrieNode root = new TrieNode();

    public void addWord(String word) {

        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.childern[ch-'a'] == null)
                    node.childern[ch-'a'] = new TrieNode();
            node = node.childern[ch-'a'];    
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    public boolean match(char ch[], int k, TrieNode node){

        //base
        if(k == ch.length)
            return node.isWord;

        if(ch['k'] == '.'){
            for(int i = 0 ;i < node.childern.length; i++){
                if(node.childern[i] != null && match(ch, k+1, node.childern[i]))
                    return true;
            }
        } else {
            return (node.childern[ch[k] - 'a']) != null && match(ch, k+1, node.childern[ch[k] - 'a']);
        }
        
        return false;
    }

}
class ImplementTrie{
    
    //time complexity : O(NM);
    //space complexity : O(K) max length of given word
    //leet code : yes
    //steps create Trienode with node and boolean variable. initialsie constructor with dict variable to be 26.thus everynode will get 26chars occupation.
    // the insert method will begin from cursor and check if it's null and assign individual char if not it'll goto it's child node and adds char till end of word and marks it with EndOfWord boolean.
    // similarly starts with and search. the only diff is search runs for exact match of word where as startswith checks for prefix and returns back.

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

    public boolean search(String word){
        TrieNode cursor = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cursor.childern[ch-'a']==null){
                return false;
            }
            cursor = cursor.childern[ch-'a'];
        }
        return cursor.isEndOfWord;
    }
    

    public boolean startsWith(String word){
        TrieNode cursor = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cursor.childern[ch-'a']==null){
                return false;
            }
            cursor = cursor.childern[ch-'a'];
        }
        return true;
    }


    public class TrieNode {
        TrieNode[] childern;
        boolean isEndOfWord;
    
        TrieNode(){
            childern = new TrieNode[26];
        }
    }

}


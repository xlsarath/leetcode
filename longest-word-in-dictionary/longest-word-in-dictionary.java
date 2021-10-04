class Solution {
    
    TrieNode root;
    String longestWord;
    
    Solution(){
        root = new TrieNode();
    }
    
    class TrieNode{
        
        TrieNode childern[];
        boolean isEndOfWord;
        
        TrieNode(){
            childern = new TrieNode[26];
        }
        
        public void insert(String word){
            
            TrieNode cursor = root;
            for(int i = 0 ; i < word.length(); i++){
                char ch = word.charAt(i);
                if(cursor.childern[ch-'a'] == null)
                    cursor.childern[ch-'a'] = new TrieNode();
                cursor = cursor.childern[ch-'a'];
            }
            cursor.isEndOfWord = true;
        }
        
        public String longestWord(){
            longestWord = "";
            backTrack(root, new StringBuilder());
            return longestWord;
        }
        
        public void backTrack(TrieNode node, StringBuilder sb){
            
            if(node.isEndOfWord  && longestWord.length() < sb.length())
                longestWord = sb.toString();
            
            for(int i = 0; i < 26; i++){
                
                if(node.childern[i] != null && node.childern[i].isEndOfWord){
                    sb.append((char) (i+'a'));
                    backTrack(node.childern[i], sb);
                    sb.deleteCharAt(sb.length()-1);
                }
                
            }
        }
        
    }
    public String longestWord(String[] words) {
        
        TrieNode node = new TrieNode();
        for(String word : words)
            node.insert(word);
        return node.longestWord();
    }
}
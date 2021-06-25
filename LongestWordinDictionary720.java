//time complexity :  for insertion length of longestword in list O(K)
//space complexity : O(h) height of tire
//leet code : yes
// steps :  Used DFS to iterate over tire. while doing verified if current length of word lesser than previous call and update if required. 
class LongestWordinDictionary720{

    TrieNode root;
    String longestWord;
    LongestWordinDictionary720(){
        root = new TrieNode();
    }

    class TrieNode{

        TrieNode[] childern;
        boolean isEndOfWord;

        TrieNode(){
            childern = new TrieNode[26];
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

        public String longestWord() {
            longestWord ="";
            dfs(root, new StringBuilder()); {
            return longestWord;
            }
        }

        private void dfs(TrieNode root, StringBuilder sb) {

            if(root.isEndOfWord && longestWord.length()<sb.length()){
                longestWord = sb.toString();
            }

            for(int i=0;i<26;i++){
                if( root.childern[i]!=null && root.childern[i].isEndOfWord ){
                    sb.append((char)(i+'a'));
                    dfs(root.childern[i],sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }


        }


    }



    public String longestWord(String[] words) {
    
    TrieNode trie = new TrieNode();

    for(String s: words){
        trie.insert(s);
    }
    
    
    return trie.longestWord();
    }

    public static void main(String[] args) {
        LongestWordinDictionary720 lw = new LongestWordinDictionary720();

            String dict[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"}; 

            System.out.println(lw.longestWord(dict));

    }

}
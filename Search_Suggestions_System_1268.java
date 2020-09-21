import java.util.*;




public class Search_Suggestions_System_1268 {

     

    class TrieNode {
        PriorityQueue<String> words = new PriorityQueue<String>((a, b) -> b.compareTo(a));
        Map<Character, TrieNode> children = new HashMap();
    }
    
    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c))
                    node.children.put(c, new TrieNode());
                node = node.children.get(c);
                node.words.add(word);
                if (node.words.size() > 3)
                    node.words.poll();
            }
        }
        
        public List<List<String>> suggest(String searchWord) {
            TrieNode node = root;
            List<List<String>> result = new ArrayList();
            
            for (int i = 0; i < searchWord.length(); i++) {
                char c = searchWord.charAt(i);
                if (!node.children.containsKey(c)) {
                    while (i++ < searchWord.length()) {
                        result.add(new ArrayList());
                    }
                }
                    
                else {
                    node = node.children.get(c);
                    String[] arr = new String[node.words.size()];
                    for (int j = node.words.size() - 1; j >= 0; j--) {
                        arr[j] = node.words.poll();
                    }
                    result.add(Arrays.asList(arr));
                }
            }
            
            return result;
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);
        List<List<String>> result = new LinkedList<>();
        if(products == null || searchWord.length() == 0) return result;
        for(int i = 1 ; i <= searchWord.length(); i++){
            ArrayList<String> list = new ArrayList<>();
            String match = searchWord.substring(0,i);
            int count  = 0 ;
            for(String product : products){
                if(product.startsWith(match) && count < 3 ){
                    list.add(product);
                    count++;
                }else if (count >= 3) break;
            }
            result.add(list);
        }
        
        return result;
    }

    public static void main(String[] args) {

        String s1[] = {"havana"};
        String []s2 = {"mobile","mouse","moneypot","monitor","mousepad"};
        String s3[] = {"bags","baggage","banner","box","cloths"};

        for(List<String> list : suggestedProducts(s2, "mouse"))
            System.out.println(list);


        Search_Suggestions_System_1268 sc = new Search_Suggestions_System_1268();
        for( List<String> lt : sc.suggestedProductsOptimised(s2,"mouse"))
                System.out.println(lt);
        
    }

    private List<List<String>> suggestedProductsOptimised(String[] s2, String searchWord) {

        Trie trie = new Trie();
        for(String word : s2)
            trie.insert(word);
        return trie.suggest(searchWord);    
    
    }
}
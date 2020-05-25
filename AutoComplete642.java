import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
//time complexity : O(nlog(n))
//sapce complexity : O(n)
//leet code : nope
//steps: implemented using tries and heap.
public class AutoComplete642 {

    private TrieNode root;
    private StringBuilder prefix;
    private TrieNode persistentCursor;
    private int k;
    private Comparator<Map.Entry<String,Integer>> comparator;

    public AutoComplete642(String[] sentences, int[] times){
        root = new TrieNode();
        prefix = new StringBuilder();
        k=3;
        persistentCursor = root;

        comparator = new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> entry1, Map.Entry<String,Integer> entry2){
                if(entry1.getValue()==entry2.getValue()){
                    //look at string's lex order
                    return entry2.getKey().compareTo(entry1.getKey());
                }
                //look at frequency
                return entry1.getValue()-entry2.getValue();
            }
        };

        //record sentences

        for(int i=0; i<sentences.length; i++){
            record(sentences[i],times[i]);
        }
    }

    //insert sentence s into trie map
    //records frequency on the go at each node

    private void record(String s, int frequncet) {
    
        TrieNode cursor = root;
        for(char c:s.toCharArray()){
            if(cursor.childern.get(c) == null ){
                cursor.childern.put(c, new TrieNode());
            }
            cursor = cursor.childern.get(c);
            cursor.frequencyMap.put(s, cursor.frequencyMap.getOrDefault(s, 0));
        }
        cursor.isWord = true;
    }

    //char c was typed in the prompt
    //if c >= # record it
    //otherwise return top k results

    public List<String> input(char c){
        //if end of sentence : '#'
        //record this in all maps from root till here
        if(c=='#'){
            record(prefix.toString(), 1);
            prefix.setLength(0);//reset prefix;
            persistentCursor = root;
            return new ArrayList<String>();
        }

        //consider current char
        prefix.append(c);

        if(persistentCursor.childern.get(c)==null){
            persistentCursor.childern.put(c, new TrieNode());
        }
        persistentCursor = persistentCursor.childern.get(c);

        //selection of top k entries,we're iterating on frequency map 

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(comparator);
            for(Map.Entry<String,Integer> entry: persistentCursor.frequencyMap.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        //collect result from pq into list
        LinkedList<String> topK = new LinkedList<String>();
        while(pq.size()>0){
            topK.addFirst((String)pq.poll().getKey());
        }
        return topK;
    }




}

//plain old trieNode
class TrieNode{
    Map<Character,TrieNode> childern;
    boolean isWord;

    //to record sentence frequncey
    Map<String,Integer> frequencyMap;

    public TrieNode(){
        childern = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
}
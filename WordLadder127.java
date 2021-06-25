import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder127 {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            
            Queue<String> q = new LinkedList<String>();
            HashSet<String> set = new HashSet<>();
    
            q.add(beginWord);
            int level = 1;
            
            while(!q.isEmpty()){
                    
                int size = q.size();
                
                while(size --> 0){
                    String t = q.poll();
                    
                    if(t.equals(endWord)) return level;
                    if(set.contains(t)) continue;
                    
                    for(String str : getAdjacencyList(t,wordList)){
                        q.add(str);
                    }
                    
                    set.add(t);
                    
                }
                
                level++;
                
            }
            return 0;
            
        }
        
        public List<String> getAdjacencyList(String t, List<String> wordList){
           
            List<String> list = new ArrayList<>();
            for(String s : wordList){
                    if(oneCharDiff(s,t))
                        list.add(s);
            }
            return list;
        }
        
        public boolean oneCharDiff(String s, String t){
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != t.charAt(i))
                    count++;
            }
            return count == 1;
        }
        
        
        
    }
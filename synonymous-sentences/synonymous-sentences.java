class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        
        List<String> result = new ArrayList<>();
        
        if(synonyms == null || text.length() == 0) return result;
        
        Queue<String> q = new LinkedList<>();
        q.add(text);
        HashMap<String,List<String>> adjacencyMap = getAdjacencyMap(synonyms);
  
        TreeSet<String> set = new TreeSet<>(); //important to ensure synonyms are sorted.
        
        while(!q.isEmpty()){
            String current = q.remove();
            set.add(current);
            String words[] = current.split("\\s");
           for(int i = 0 ; i < words.length; i++){
               
                   if(adjacencyMap.get(words[i]) == null) continue;
                   for(String synonym : adjacencyMap.get(words[i])){
                        words[i] = synonym;
                        String newText = String.join(" ", words);
                        if(!set.contains(newText))
                           q.offer(newText);
                   
               }
           }
        }
        return new ArrayList<>(set);
    }
    
    
   
    public HashMap<String,List<String>> getAdjacencyMap(List<List<String>> synonyms){
        
        HashMap<String,List<String>> map = new HashMap<>();
        for(List<String> synonym : synonyms){
            map.putIfAbsent(synonym.get(0), new ArrayList<>());
            map.putIfAbsent(synonym.get(1), new ArrayList<>());
            map.get(synonym.get(0)).add(synonym.get(1));
            map.get(synonym.get(1)).add(synonym.get(0));
        }
        
        return map;
    }
}
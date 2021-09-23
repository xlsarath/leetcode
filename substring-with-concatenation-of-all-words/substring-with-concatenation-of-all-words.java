class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
      HashMap<String,Integer> map = new HashMap<>();
       
      for(String word : words)  
          map.put(word, map.getOrDefault(word,0)+1);

       HashMap<String,Integer> temp = new HashMap<>();
       temp = (HashMap) map.clone();
        
      int wordLen = words[0].length();
      int concatLen = wordLen * words.length;  
      int start = 0, end = 0;  
      List<Integer> result = new ArrayList<>();
      while(end < s.length()){
          
          end = start;
          
          if(s.length() - end < concatLen) break;
          
          temp = (HashMap) map.clone();
          while(end + wordLen <= s.length() && temp.containsKey(s.substring(end, end+wordLen)) && temp.size() > 0){
              int val = temp.get(s.substring(end, end+wordLen));
              if(val- 1 == 0)
                  temp.remove(s.substring(end, end+wordLen));
              else
                  temp.put(s.substring(end, end+wordLen), val -1);
              end += wordLen;
          }
          
          
          if(temp.size() == 0)
              result.add(start);
          
          
          start++;
      }  
        
       return result; 
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            
            int ch[] = new int[26];
            Arrays.fill(ch, 0);
            for(char st : str.toCharArray()) ch[st-'a']++;
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++){
                sb.append(ch[i]);
                sb.append("*");
            }    
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(str);
        }
        
          return new ArrayList<>(map.values());  
            
        
    }
}
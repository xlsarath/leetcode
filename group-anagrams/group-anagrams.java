class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        
        for(String str : strs){
        int chars[] = new int[26];
        for(char ch: str.toCharArray()) chars[ch-'a']++;
            
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 26; i++) 
        {   
            sb.append("*");
            sb.append(""+chars[i]);
        }    
         
        map.putIfAbsent(sb.toString(), new ArrayList<>());
        map.get(sb.toString()).add(str);    
        }
        return new ArrayList<>(map.values());
    }
}
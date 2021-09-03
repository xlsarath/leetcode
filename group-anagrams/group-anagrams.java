class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
             
        if(strs == null || strs.length == 0) return new ArrayList<>();
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str : strs){
            
            int count[] = new int[26];
            Arrays.fill(count,0);
            for(char ch : str.toCharArray()) count[ch-'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++){
                sb.append("*");
                sb.append(count[i]);
            }
            
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(str);    
        }
        
        return new ArrayList<>(map.values());
    }
}
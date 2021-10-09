class Solution {
    
    int max = 0;
    
    public int maxLength(List<String> arr) {
    
        if(arr == null || arr.size() == 0) return 0;
         backTrack(arr, new StringBuilder(), 0);
        
        return max;
    }
    
    
    public void backTrack(List<String> arr, StringBuilder sb, int idx){
        
        boolean isUnique = isUnique(sb);
        
        if(isUnique) max = Math.max(max, sb.length());
        
        if(idx == arr.size() || !isUnique) return;
            
        for(int i = idx; i < arr.size(); i++){
            sb.append(arr.get(i));
            backTrack(arr, sb, i+1);
            sb.delete(sb.length()-arr.get(i).length(),sb.length());
        }
    }    
    
    
    public boolean isUnique(StringBuilder sb){
        
        HashSet<Character> set = new HashSet<>();
        for(char ch : sb.toString().toCharArray()){
            if(set.contains(ch))
                return false;
            set.add(ch);   
        }
        return true;
    }
}
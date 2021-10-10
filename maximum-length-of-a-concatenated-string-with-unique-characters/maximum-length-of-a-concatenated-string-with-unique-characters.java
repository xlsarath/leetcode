class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        
        if(arr == null || arr.size() == 0) return max;
        backTrack(arr, 0, new StringBuilder());
        return max;
    }
    
    public void backTrack(List<String> arr, int idx, StringBuilder sb){
        
        boolean valid = isValid(sb.toString());
        
        if(valid) max = Math.max(max, sb.length());
        
        if(idx == arr.size() || !valid) return;
        
        for(int i = idx; i < arr.size(); i++){
            sb.append(arr.get(i));
            backTrack(arr, i+1, sb);
            sb.delete(sb.length() - arr.get(i).length(), sb.length());
        }
    }
    
    public boolean isValid(String temp){
        
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < temp.length(); i++){
            if(set.contains(temp.charAt(i)))
                    return false;
            set.add(temp.charAt(i));
        }
        return true;
    }
}
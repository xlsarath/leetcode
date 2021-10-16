class Solution {
    public List<String> letterCasePermutation(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        List<String> result = new ArrayList<>();
        
        dfs(result, s,"", 0);
        
        return result;
    }
    
    public void dfs(List<String> result, String s, String temp, int idx){
        
        if(temp.length() == s.length()){
            result.add(temp);
            return;
        }
        
        if(Character.isDigit(s.charAt(idx))){
            dfs(result, s, temp+s.charAt(idx), idx+1);
        } else {
            dfs(result, s, temp+Character.toLowerCase(s.charAt(idx)), idx+1);
            dfs(result, s, temp+Character.toUpperCase(s.charAt(idx)), idx+1);
        }
        
    }
}
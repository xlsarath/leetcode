class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        backTrack(n, 0, 0, "", result);
        return result;
    }
    
    public void backTrack(int n, int open, int close, String temp, List<String> result){
        
        if(temp.length() == n * 2){
            result.add(temp);
            return;
        }
        
        if(open < n)
            backTrack(n, open+1, close, temp+"(", result);
        
        if(close < open)
            backTrack(n, open, close+1, temp+")", result);
    }
}
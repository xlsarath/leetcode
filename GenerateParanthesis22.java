import java.util.LinkedList;
import java.util.List;

class GenerateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new LinkedList<>();
        
        backtrack(result,n,"",0,0);
        
        return result;
    }
    
    
    public void backtrack(List<String> result, int n, String cur, int open, int close){
        
        if(cur.length() == n*2){
            result.add(cur);
            return;
        }
        
        if(open<n){
            backtrack(result,n,cur+"(",open+1,close);
        }
        if(close<open){
            backtrack(result,n,cur+")",open,close+1);
        }
        
        
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis22().generateParenthesis(4));
    }
}
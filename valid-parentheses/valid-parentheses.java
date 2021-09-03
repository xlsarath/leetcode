class Solution {
    public boolean isValid(String s) {
        
       if(s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){
            
            
            if(ch == '(') stack.push(')');
            if(ch == '{') stack.push('}');
            if(ch == '[') stack.push(']');
            
            if(ch == '}' || ch == ']' || ch ==')'){
                if(stack.isEmpty()) return false;
                if(ch!=stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}
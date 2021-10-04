class Solution {
    public int myAtoi(String s) {
        
        s = s.trim();
        
        double result = 0;
        boolean isNegative = false;
        
        if(s == null || s.length() == 0) return 0;
        
        if(s.charAt(0) == '-')
            isNegative = true;
        else if(s.charAt(0) == '+')
            isNegative = false;
        else if(s.charAt(0) <= '9' && s.charAt(0) >= '0')
            result = s.charAt(0)-'0';
        else 
            return 0;
        
        for(int i = 1 ; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                result = result * 10 + s.charAt(i) - '0';
            }else
                break;
        }
        
        if(isNegative)
            result = 0 - result;
        
        if(result < Integer.MIN_VALUE)return Integer.MIN_VALUE;
        else if(result > Integer.MAX_VALUE)return Integer.MAX_VALUE;
        
        return (int) result;
    }
}
import java.util.Stack;
//time complexity : O(n)
//space complexity :O(1)
//leet code : yes
//steps : implemented using stack
class BasicCalculatorII227 {


    public int calculate(String s) {
    if(s==null||s.length()==0) return 0;

    int i =0;
    int value =0;
    char sign = '+';
    Stack<Integer> stack = new Stack<>();
        while(i<s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                value = value * 10 + (ch -'0');
            }
            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(sign=='+')
                stack.push(value);
                if(sign=='-')
                stack.push(-value);
                if(sign=='*')
                stack.push(stack.pop() * value);
                if(sign=='/')
                stack.push(stack.pop() / value);

                value = 0;
                sign = ch;
            }
            i++;
        }
        int result = 0;
        while(!stack.isEmpty()) result += stack.pop();
    
    return result;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII227().calculate("2*7-1"));
    }
}
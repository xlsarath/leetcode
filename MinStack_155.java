import java.util.*;

class MinStack_155 {
    Stack<Integer> elementStack ;
    Stack<Integer> minStack ;

    public MinStack_155() {
        
            elementStack = new Stack<>();
          minStack  = new Stack<>();
        
    }
    
    public void push(int x) {

        elementStack.push(x);
        int min = Math.min(x,minStack.peek());
        minStack.push(min);
    }
    
    public void pop() {
        elementStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return elementStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }



}



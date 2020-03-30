import java.util.Iterator;
import java.util.List;
import java.util.Stack;
//time complexity : O(n)
//space complexity : O(1)
//leet code execution : yes
//steps : listed below
/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class FalttenNestedListIterator341 implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack;
    Integer cursor;

    public FalttenNestedListIterator341(List<NestedInteger> nestedList) {
        stack = new Stack<>();
    if(nestedList!=null){
        stack.push(nestedList.iterator());
    }
}

@Override
public Integer next() {
    int value = cursor;
    cursor =null;
    return value;
}

@Override
public boolean hasNext() {
    boolean hasNext = false;
    
    while(true){
        if(stack.isEmpty()  && cursor ==null){
            hasNext = false;
            break;
        }
        
        
        Iterator<NestedInteger> iterator = stack.peek();
        if(!iterator.hasNext()){
            stack.pop();
        } else {
            NestedInteger nestedInteger =  iterator.next();
            if(nestedInteger.isInteger()){
                cursor = nestedInteger.getInteger();
                hasNext = true;
                break;
            } else {
                stack.push(nestedInteger.getList().iterator());
            }
        }
    }
    return hasNext;
}
}

/**
* Your NestedIterator object will be instantiated and called as such:
* NestedIterator i = new NestedIterator(nestedList);
* while (i.hasNext()) v[f()] = i.next();
*/
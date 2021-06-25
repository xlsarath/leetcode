import java.util.Arrays;
import java.util.Stack;
//time complexity : O(2*n)
//space complexity : O(n)
//leet code : yes
//steps : implemented using monotonic stacks concept.
public class NextGreaterElementII503 {

        public int[] nextGreaterElements(int[] nums) {
            
            
            Stack<Integer> stack = new Stack<>();
            int result[] = new int[nums.length];
            Arrays.fill(result,-1);
            int n = nums.length;
            
            for(int i=0; i<2*n; i++){
                
                while(!stack.isEmpty() && nums[i%n]>nums[stack.peek()]){
                    int priorIndex = stack.pop();
                    result[priorIndex]= nums[i%n];
                }
                
                if(i<n) stack.push(i%n);
                
            }
            
            return result;
        }
    }
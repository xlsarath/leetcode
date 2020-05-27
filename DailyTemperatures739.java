import java.util.Stack;
//time compelxity : O(n)
//space complexity : O(n)
//leet code : yes
//steps : implemented using monotonic stack
class DailyTemperatures739 {


    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];

        for(int i =0 ;i < T.length; i++){
            while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                int priorIndex = stack.pop();
                result[priorIndex] = i-priorIndex;
            }
            stack.push(i);
        }
    return result;

    }

    public static void main(String[] args) {
        for(int i: new DailyTemperatures739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})){
            System.out.println(i);
        }
    }

}
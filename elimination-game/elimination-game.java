class Solution {
    public int lastRemaining(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 1) {
            n /= 2;
            stack.push(n);
        }
        int result = 1;
        while (!stack.isEmpty()) {
            result = 2 * (1 + stack.pop() - result);
        }
        return result;
    }
}
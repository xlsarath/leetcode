import java.util.Arrays;

public class PlusOne66 {

    public int[] plusOne(int[] digits) {
        
        return dfsVisit(digits, digits.length -1);
    
    }

    public int[] dfsVisit(int[] digits, int index) {
        if (digits[index] != 9) {
            digits[index]++;
            return digits;
        } else if (index != 0) {
            digits[index] = 0;
            return dfsVisit(digits, index - 1);
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
    }

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(new PlusOne66().plusOne(new int[]{1,9,9,9})));
    }

}
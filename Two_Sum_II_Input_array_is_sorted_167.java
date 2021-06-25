//time complexity : O(n2)
//space complexity : O(1)

public class Two_Sum_II_Input_array_is_sorted_167 {

    public static int[] twoSum(int[] numbers, int target) {
        
        for(int i = 0 ; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[i]+numbers[j] == target) return new int[]{i+1,j+1};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        
        for(int i : twoSum(new int[]{2,7,11,15}, 9)) System.out.print(i+" ");

    }
}
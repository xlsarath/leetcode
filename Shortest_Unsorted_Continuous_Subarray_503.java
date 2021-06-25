
public class Shortest_Unsorted_Continuous_Subarray_503 {

    public static int findUnsortedSubarray (int nums[]){

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i = 1 ; i < nums.length ;i++) {
            if(nums[i] < nums[i-1]) flag = true;
            if(flag) min = Math.min(min,nums[i]);
        }
        flag= false;
        for(int i = nums.length -2 ; i >= 0 ; i--){

            if(nums[i] > nums[i+1]) flag = true;
            if(flag) max = Math.max(max,nums[i]);
        }
        int l,r;
        for(l = 0 ; l < nums.length; l++) if(min > nums[l]) break;

        for(r = nums.length -1; r >= 0 ; r++) if(max < nums[r]) break;

        return r - l < 0 ? 0 : r - l + 1; 
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[] {2,4,6,8,9,7,15}));
    }

}
import java.util.*;
//Time Complexity :  O(4^N)
//space complexity :O(N)

public class Matchsticks_to_Square_473 {
 

        public int[] sums = new int[4];
    
       
    
        // Depth First Search function.
        public boolean dfs(int index, int[] nums) {
    
            // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
            if (index == nums.length) {
                return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
            }
    
            // Get current matchstick.
            int element = nums[index];
    
            // Try adding it to each of the 4 sides (if possible)
            for(int i = 0; i < 4; i++) {
                if (sums[i] + element <= this.possibleSquareSide) {
                    sums[i] += element;
                    if (dfs(index + 1, nums)) {
                        return true;
                    }
                    sums[i] -= element;
                }
            }
    
            return false;
        }
        int possibleSquareSide;
        public boolean makesquare(int[] nums) {
            // Empty matchsticks.
            if (nums == null || nums.length == 0) {
                return false;
            }
    
            // Find the perimeter of the square (if at all possible)
            int L = nums.length;
            int perimeter = 0;
            for(int i = 0; i < L; i++) {
                perimeter += nums[i];
            }
    
            possibleSquareSide =  perimeter / 4;
            if (possibleSquareSide * 4 != perimeter) {
                return false;
            }
    
            // Convert the array of primitive int to ArrayList (for sorting).
            nums = Arrays.stream(nums).boxed()
        .sorted(Collections.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();
            
            return dfs(0,nums);
        }
    }

}


//time complexity : O(n)
//space complexity : O(1)
//leet code : yes
//steps :  greedy approach.
public class JumpGame55 {

        public boolean canJump(int[] nums) {
            
            if(nums==null || nums.length<2 ) return true;
            
            int destination = nums.length-1;
            
            for(int i=destination ; i>=0; i--){
                if(i + nums[i] >= destination)
                    destination=i;
            }
            
            return destination==0;
            
        }

        public static void main(String[] args) {
            System.out.println(new JumpGame55().canJump(new int[]{2,3,1,1,4}));
            System.out.println(new JumpGame55().canJump(new int[]{3,2,1,0,4}));
        }
    }
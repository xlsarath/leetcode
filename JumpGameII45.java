
//time complexity : O(n)
//space complexity : O(1)
//leet code : yes
//steps : greedy approach
public class JumpGameII45 {

        public int jump(int[] nums) {
            
            int scope =0, farthest =0, jumps =0;
            if(nums.length==1) return 0;
            for(int i =0;i<nums.length; i++){
                farthest = Math.max(farthest,i+nums[i]);
                if(farthest >= nums.length-1) return jumps+1;
                if(i==scope){
                    jumps++;
                    scope = farthest;
                }
                
            }
            
            return jumps;
            
        }
    }
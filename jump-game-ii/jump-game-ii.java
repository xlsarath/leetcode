class Solution {
    //[2,3,1,1,4]
    //   1 2 1 0       
    
    public int jump(int[] nums) {
        
        int memo[] = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[nums.length -1] = 0;
        
        
        for(int i = nums.length - 2; i >= 0 ; i--){
            
            int farthest = Math.min(i+nums[i],nums.length-1);
            
            for(int j = i+1; j <= farthest; j++){
                if(memo[j] == Integer.MAX_VALUE)
                    continue;
                memo[i] = Math.min(1+memo[j], memo[i]);
            }
            
        }
        return memo[0];
    }
}
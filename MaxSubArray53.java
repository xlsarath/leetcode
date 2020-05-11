class MaxSubArray53{

        public int maxSubArray(int[] nums) {
            
            if(nums.length==0) return Integer.MIN_VALUE;
            int rSum = nums[0];
            int res = nums[0];
            for(int i=1; i<nums.length; i++){
               
                rSum = Math.max(rSum+nums[i],nums[i]);
                res = Math.max(rSum,res);
            }

            return res;
            
        }
    

    public static void main(String[] args) {
        
        MaxSubArray53 mx = new MaxSubArray53();
        System.out.println(mx.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }                                                             

}
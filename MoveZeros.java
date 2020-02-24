class MoveZeroes {
    public void moveZeroes(int[] nums) {
         
        //basic checks
        if(nums==null||nums.length<=1) return;
        int first=0, last = 1;
        
        while (last < nums.length && first <= nums.length-1){
           if(nums[last]!=0 && nums[first]==0){ //0,1
               nums[first] = nums[last];
               nums[last] = 0;
               first++;
           }  
        if(nums[first]!=0 && nums[last]==0){
            first++;last--;
        }
           
          last++;
           
        
    }

    return;
   
    }


    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int [] arr = {1,0,1};
        mz.moveZeroes(arr);
    }
}
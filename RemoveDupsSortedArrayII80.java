class RemoveDupsSortedArrayII80{

    public int removeDuplicates(int []nums){

        int fast=2,slow=2;
        for(fast=2;fast<nums.length;fast++){
            if(nums[fast]>nums[slow-2]){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        
        return slow;

    }


    public static void main(String[] args) {

        RemoveDuplicatesSortedArrayII80 rdsa = new RemoveDuplicatesSortedArrayII80();
        int [] nums = {1,1,1,2,2,3};
        System.out.println(
            rdsa.removeDuplicates(nums)
        );
        
    }
}
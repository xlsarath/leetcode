//time complexity : O(n)
//space complexity : O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];
        int leftProd = 1, rightProd = 1;
        
        //left -> right
        result[0] = 1;
        for(int i = 1; i < nums.length; i++){
            result[i] = leftProd * nums[i-1];
            leftProd = result[i]; 
        }
        
        //right - left
        for(int i = nums.length - 1; i >= 0 ; i-- ){
            result[i] = rightProd * result[i];
            rightProd = rightProd * nums[i];
        }
        
        return result;
    }
}
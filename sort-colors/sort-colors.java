/**
time complexity : O(n)
space complexity : O(1)
Dijkstra. Dutch National Flag Problem

*/

class Solution {
    public void sortColors(int[] nums) {
        
        int low = 0, mid = 0,high = nums.length -1;
        
        while(mid <= high){
            
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) mid++;
            else {
                swap(nums,mid,high);
                high--;
               // mid++;
            }
            
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
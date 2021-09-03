/**
time complexity : O(m + n)
space complexity : O(1)
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
      int first = m -1 ; int second = n - 1;
        
        while(first >= 0 && second >= 0){
            
            if(nums1[first] > nums2[second] ){
                nums1[first+second+1] = nums1[first];
                first--;
            } else {
                nums1[first+second+1] = nums2[second];
                second--;
            }
            
        }

        while(second >= 0){
            nums1[second] = nums2[second];
            second--;
        }
        
    }
}

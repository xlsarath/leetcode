//time complexity : O(n)
//space complexity : O(1)
class Solution {
    public int maxArea(int[] height) {
        
        int distance = 0;
        
        int start = 0, end = height.length -1;
        
        while(start < end){
            
            distance = Math.max(distance,(end - start)*Math.min(height[start],height[end]));
            
            if(height[start] < height[end]) start++;
            else end--;
            
        }
        return distance;
    }
}
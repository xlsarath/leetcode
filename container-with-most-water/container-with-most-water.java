class Solution {
    public int maxArea(int[] height) {
        
        int result = 0;
        
        if(height.length == 0) return result;
        
        int start = 0, end = height.length - 1;
        
        while(end >= start){
            
            int vol = (end - start) * (Math.min(height[end], height[start]));
            
            result = Math.max(result, vol);
            
            if(height[start] > height[end])
                end--;
            else 
                start++;
        }
        
        return result;
        
    }
}
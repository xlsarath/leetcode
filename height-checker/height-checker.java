class Solution {
    public int heightChecker(int[] heights) {
        
        int countFreq[] = new int[101];
        
        for(int height : heights) countFreq[height]++;
        int index = 0, res = 0;
        
        for(int i = 0; i < heights.length; i++){
            
            while(countFreq[index] == 0) index++;
            
            if(heights[i] != index)        
                res += 1;
    
            
            countFreq[index]--;
        }
        
        
        return res;
    }
}
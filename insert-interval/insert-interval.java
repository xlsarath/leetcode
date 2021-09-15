class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> result = new ArrayList<>();
                
        for(int i = 0; i < intervals.length; i++){
            
                if(intervals[i][0] > newInterval[1] ){
                    result.add(newInterval);
                    newInterval = intervals[i];
                } else if( intervals[i][1] >= newInterval[0]) {
                    newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), 
                                        Math.max(newInterval[1], intervals[i][1])};
                } else {
                    result.add(intervals[i]);
                }
           
        }
        result.add(newInterval);
            return result.toArray(new int[result.size()][]); 
    }
}

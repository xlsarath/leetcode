//time complexity : O(n)
//space comolexity : O(1)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> result = new ArrayList<>();
        
        for(int i = 0 ; i < intervals.length; i++){
            
            //when to add newInterval to result list ?? [when we cross the expanded Interval]
            if(intervals[i][0] > newInterval[1]){
                result.add(newInterval); //[1,5]
                newInterval = intervals[i]; //[6,9] 
            }
            
            //expanding interval
            if(intervals[i][1] >= newInterval[0]) { //[1,5]
                newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]),
                                       Math.max(intervals[i][1], newInterval[1])};
            } else {
                result.add(intervals[i]);
            }

        }
        
        //left over interval
        result.add(newInterval);//[6,9]
    return result.toArray(new int[result.size()][]);        
        
    }
}

//time complexity : O(nlogn)
//space complexity : O(1);

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1])); // sorting is the trick here. 
        
        int prev[] = intervals[0];
        int overlapCount = 1;
       for(int interval[] : intervals){
            if(interval[0] >= prev[1]){
                overlapCount++;
                prev = interval;
            }
        }
        
        return intervals.length  - overlapCount;   
        
    }
}


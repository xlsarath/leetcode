class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        result.add(prev);
        for(int interval[] : intervals){
            
            if(interval[0] <= prev[1]){
                prev[1] = Math.max(prev[1],interval[1]);
            } else{
                prev = interval;
                result.add(prev);
            }
        }
        
        return result.toArray(new int[result.size()][]);
        
        
    }
}
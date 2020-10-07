import java.util.*;

//time complexity : o(n);
//space complexity : O(n);
public class InsertInterval57 {

    public static int[][] insert(int[][] intervals, int[] toAdd) {
        
        List<int[]> result = new ArrayList<>();
          
          for(int i = 0 ; i < intervals.length; i++){
              
              if(intervals[i][0] > toAdd[1]){
                  result.add(toAdd);
                  toAdd = intervals[i];
              } else if (intervals[i][1] >= toAdd[0])
                  toAdd = new int[] {Math.min(intervals[i][0],toAdd[0]),
                                    Math.max(intervals[i][1],toAdd[1])};
              else 
                  result.add(intervals[i]);
          }
          result.add(toAdd);
          return result.toArray(new int[result.size()][2]);
      }
public static void main(String[] args) {
    for(int[] i : InsertInterval57.insert(new int [][]{{1,3},{6,9}}, new int[]{2,5}))
            System.out.println(i[0]+" "+i[1]);

}
    }

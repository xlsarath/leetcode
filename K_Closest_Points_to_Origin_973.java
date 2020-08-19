import java.util.Arrays;
import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin_973 {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (p1,p2) ->  ( (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]))
        );

        for(int[] point : points){
            pq.offer(point);
            if(pq.size() > k) pq.poll();
        }

        int [][] res = new int[k][2];

        while(k > 0){
            res[--k] = pq.poll();
        }

        return res;
    }
    
    
    public static void main(String[] args) {
        
        System.out.println(Arrays.deepToString(new K_Closest_Points_to_Origin_973().kClosest(new int[][] {{1,3},{-2,2}}, 1)));
    }

}
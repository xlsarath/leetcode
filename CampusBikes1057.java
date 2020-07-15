//time complexity : O(bw log bw) --treemap, optimised appraoch O(bw)
//space compliety : O(bw)


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CampusBikes1057 {


    public int[] assignBikes_optimized(int[][] workers, int[][] bikes){

        int W = workers.length;
        int B = bikes.length;

        // add to treemap

       // Map<Integer, List<int[]>> map = new TreeMap<>();
        List<int[]>[] arr = new List[2005];  // max manhattan distance can be 2000 for the case where worker is at (0,0) and bike at(1000,1000)
        
        for(int w = 0; w < W; w++){
            for(int b = 0; b < B; b++){

                int dist = computeManhattanDistance(workers[w],bikes[b]);

                if(arr[dist]==null){
                    arr[dist] = new ArrayList<>();
                }

                arr[dist].add(new int[] {w, b});
            }
        }

        //assign bikes to workers
        boolean[] workerStatus = new boolean[W];
        boolean[] bikesStatus = new boolean[B];

        int []result = new int[W];

        for(List<int[]> list : arr){
            
            if(list == null) continue;

            for(int[] workerBikeStatus : list){
                int w = workerBikeStatus[0];
                int b = workerBikeStatus[1];

                if(workerStatus[w] == false && bikesStatus[b] == false){
                    workerStatus[w] = true;
                    bikesStatus[b] = true;
                    
                    result[w] = b;
                }


            }

        }
         
        return result;
    }


    public int[] assignBikes_treeMap(int[][] workers, int[][] bikes){


        int W = workers.length;
        int B = bikes.length;

        // add to treemap

        Map<Integer, List<int[]>> map = new TreeMap<>();

        for(int w = 0; w < W; w++){
            for(int b = 0; b < B; b++){

                int dist = computeManhattanDistance(workers[w],bikes[b]);

                if(!map.containsKey(dist)){
                    map.put(dist, new ArrayList<>());
                }

                map.get(dist).add(new int[]{w,b});
            }
        }

        //assign bikes to workers
        boolean[] workerStatus = new boolean[W];
        boolean[] bikesStatus = new boolean[B];

        int []result = new int[W];

        for(Map.Entry<Integer, List<int[]>> entry : map.entrySet()){
            List<int[]> status = entry.getValue();

            for(int[] workerBikeStatus : status){
                int w = workerBikeStatus[0];
                int b = workerBikeStatus[1];

                if(workerStatus[w] == false && bikesStatus[b] == false){
                    workerStatus[w] = true;
                    bikesStatus[b] = true;
                    
                    result[w] = b;
                }


            }

        }
         
        return result;
    }

    private int computeManhattanDistance(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1]+b[1]);
    }

    public static void main(String[] args) {
        int[][] workers = new int[][]{{0,0},{2,1}};
        int[][] bikes = new int[][]{{1,2},{3,3}};
        for(int assign : new CampusBikes1057().assignBikes_optimized(workers, bikes))
            System.out.println(assign);
    }

}
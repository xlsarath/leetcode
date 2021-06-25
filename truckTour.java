import java.util.HashMap;

class truckTour {

   public  int ttruckTour(int[][] petrolpumps) {

        // base check
        if (petrolpumps.length == 0 || petrolpumps == null)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < petrolpumps.length; i++) {
            map.put(petrolpumps[i][0], petrolpumps[i][1]);
        }

        int dist = map.get(petrolpumps[0][0]);
        int liters = petrolpumps[0][0];
        for (int i = 1; i < petrolpumps.length; i++) {
            System.out.println(dist - petrolpumps[i][0]+" "+liters);
            if (liters - petrolpumps[i][0] > dist) {
                return i-1;
            } else {
                dist = map.get(petrolpumps[i][0]);
                liters = petrolpumps[i][0];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        truckTour tt = new truckTour();
        int[][] petrolpumps = { { 1, 5 }, { 10, 3 }, { 3, 4 } };
        System.out.println(tt.ttruckTour(petrolpumps));
    }

}
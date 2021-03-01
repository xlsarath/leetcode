import java.util.*;
public class AutoSensors {


    public  static double minCost(int k, int m[], double dollarAmt){

        Arrays.sort(m);
        
        int median = (k == m.length -1 || k == 1 )? m[m.length -1] : m[m.length-1]/k;
        List<Integer> stageSum = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> map : getLists( k,  m, median).entrySet()){
            int StageSum = 0;
            for(Integer i : map.getValue())
                StageSum += Math.abs(i - map.getKey());
            stageSum.add(StageSum);
        }
        System.out.println(stageSum+" stage sum");
        int sol = 0;
        for(Integer i : stageSum){
            sol += i;
        }

    
        return (sol * dollarAmt);
    }




    private static HashMap<Integer, List<Integer>> getLists(int k, int[] m, int median) {
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;
        for(int i = 0 ; i < k ; i++){
            List<Integer> temp = new ArrayList<>();
                while(index <= m.length-1 && m[index] <= median ) temp.add(m[index++]);
                median += median;
                lists.add(temp);
                int n = temp.size()%2 == 0  ? temp.get(temp.size()/2) : ((temp.get(temp.size() - 1) / 2) + temp.get(temp.size() / 2) / 2);
                System.out.println(n+" n values is"+temp);
                map.put(n, temp);
        }
        System.out.println(lists);
        return map;
    }

    public static void main(String[] args) {
        
        int k = 2;
        int m[] = {18,5,2,3,12};
        System.out.println(minCost(k,m, 1.25));
        int k1 = 1;
        int m1[] = {2,7,5,8};
        System.out.println(minCost(k1,m1, 1.25));


    }
    
}

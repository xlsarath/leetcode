import java.util.*;
//time complexity : nlogn
//space complexity O(k);
public class LeastNumberofUniqueIntegersafterK_Removals_1481 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr) map.put(i, map.getOrDefault(i, 0)+1);

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b) -> (map.get(a) - map.get(b)));
        int remove = 0,n = map.size(), idx =0;

        while(idx < n && k > 0){
            k -= map.get(list.get(idx++));
            if(k > 0) remove++;
        }
        return n - remove;
    }

    public static void main(String[] args) {
        System.out.println(new LeastNumberofUniqueIntegersafterK_Removals_1481().findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }

}
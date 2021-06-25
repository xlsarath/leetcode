import java.util.*;

public class Missing_NUmbers_hacker_rack {

// Complete the missingNumbers function below.
static int[] missingNumbers(int[] arr, int[] brr) {
        
    HashMap<Integer,Integer> map = new HashMap();
    for(int i = 0 ; i < brr.length; i++)
        map.put(brr[i],map.getOrDefault(brr[i],0)+1);

    System.out.println(map);
    List<Integer> res = new ArrayList();
    
    for(int i = 0; i < arr.length; i++){
        
        if(map.containsKey(arr[i])){
            int temp = map.get(arr[i]);
            --temp;
            map.put(arr[i], temp);
        } 
    }
    System.out.println(map);
    for(int i : map.keySet()){
        if(map.get(i) > 0)
            res.add(i);
    }
    
    int re[] = new int[res.size()];
    for(int i = 0 ; i < re.length; i++) re[i] = res.get(i);
    
    return re;

}
public static void main(String[] args) {
    for(int i :  Missing_NUmbers_hacker_rack.missingNumbers(new int[]{203,204,205,206,207,208,203,204,205,206}, new int[]{203,204,204,205,206,207,205,208,203,206,205,206,204}))
        System.out.println(i);
}

}
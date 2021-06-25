
import java.util.*;
public class deleteMinimalPeeks {


public Integer[] delPeeks(int[] nums){

int length = nums.length;
int i = 0;

ArrayList<Integer> arr = new  ArrayList<>();
ArrayList<Integer> num = new ArrayList<>();
for(int j : nums) num.add(j);

while(i < length){
int min = Integer.MAX_VALUE;
int size = num.size();
    for(int k = 1; k < size-1; k++ ){
        if((num.get(k) > num.get(k-1)) && (num.get(k) > num.get(k+1)))
                 min = Math.min(min,num.get(k));
        else 
              min = Math.min(min,Math.min(num.get(0),num.get(num.size()-1)));
            }
    System.out.println(min);
    arr.add(min);
    num.remove(min);
    i++;
}

Integer result[] = new Integer[arr.size()];
arr.toArray(result);
return result;
}



    public static void main(String[] args) {
        

        for(int i :  new deleteMinimalPeeks().delPeeks(new int[] {2,7,8,5,1,6,3,9,4}));
       // System.out.println(i);



    }

}
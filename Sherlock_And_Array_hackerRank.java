import java.util.*;

public class Sherlock_And_Array_hackerRank {

    static String balancedSums(List<Integer> arr) {
        if(arr == null || arr.size() <= 1) return "YES";
            
        for(int i = 0 ; i < arr.size(); i++){
            int rightSum,leftSum = 0;
                rightSum =  i == 0 ? 0 : getSum(arr,0,i);
                leftSum = i == arr.size()-1 ? 0 : getSum (arr,i+1,arr.size());  
                if(rightSum == leftSum) return "YES";
            }
                     
        return "NO";

    }

    static String balancedSumOptimal(List<Integer> arr){
        int i,sr,sl;
            sr=sl=0;
            for( i = 0; i < arr.size(); i++)
            {
                    sr += arr.get(i); 
            }
            for( i = 0; i < arr.size(); i++)
            {
                    sr=sr-arr.get(i);
                    if(sl==sr)
                    {
                        return "YES";
                    } 
                    sl=sl+arr.get(i);
            }
        return "NO";
    }


    public static int getSum(List<Integer> arr, int start, int last){
        
        int sum = 0;
        for(int i = start; i < last; i++)
            sum += arr.get(i);
        
        return sum;
    }

public static void main(String[] args) {
    
List<Integer> list1 = Arrays.asList(1,1,4,1,1);
List<Integer> list2 = Arrays.asList(2,0,0,0);
List<Integer> list3 = Arrays.asList(0,0,2,0);

System.out.println(balancedSums(list1));
System.out.println(balancedSums(list2));
System.out.println(balancedSums(list3));

System.out.println(balancedSumOptimal(list1));
System.out.println(balancedSumOptimal(list2));
System.out.println(balancedSumOptimal(list3));



}
}



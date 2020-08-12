/* Java program for efficient approach to find 
largest number having digits in non-decreasing 
order. */
import java.util.*; 


public class LargestNumberNonDecreasingOrder {


    public void printWellOrdered(int number,   int x, int k, int given, List<Integer> rev) 
    {   

       
        if(number > given){
                    return;
            }
      
        if (k == 0) 
        { 
            rev.add(number);
            return; 
        } 


        for (int i = (x + 1); i < 10; i++) 
            printWellOrdered(number * 10 +  
                             i, i, k - 1,given, rev); 
    } 
      
    public void generateWellOrdered(int k, int given, List<Integer> rev) 
    { 
        printWellOrdered(0, 0, k,given, rev); 
    } 
      
    // Driver Code  
    public static void main (String[] args)  
    { 
         String x = "4";
         int k = x.length();
        List<Integer> rev = new LinkedList<>();
        new LargestNumberNonDecreasingOrder().generateWellOrdered(k,Integer.parseInt(x),rev); 
        System.out.println(rev.get(rev.size()-1));
    } 

}  

// This code is contributed by chandan_jnu 


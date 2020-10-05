import java.util.*;

public class StockMaximize_Hacker_rank {

    public static long stockmax(List<Integer> prices) {            


        // Write your code here
            long profit = 0L;
            int maxSoFar = 0;
            for (int i = prices.size() - 1; i > -1 ; i--) {
                if (prices.get(i) >= maxSoFar) {
                    maxSoFar = prices.get(i);
                }
                profit += maxSoFar - prices.get(i);
                
            }
            return profit;
        }
    
    
public static void main(String[] args) {
    System.out.println(stockmax(Arrays.asList(1,2,100)));
}
}
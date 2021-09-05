//time complexity : O(n)
//space complexity : O(1)
class Solution {
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE, profit = 0;
        
        for(int i = 0 ; i < prices.length; i++){
            
            min = Integer.min(min, prices[i]);

            if(prices[i] > min)
                profit = Integer.max(profit, prices[i] - min);
            
        }
    return profit;        
    }
}
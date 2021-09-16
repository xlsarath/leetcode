class Solution {
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE, profit = 0;
        
        for(int i = 0 ; i < prices.length; i++){
            
            min = Math.min(min, prices[i]);
            
            if(prices[i] > min)
                profit = Math.max(profit, prices[i] - min);
            
        }
        return profit;
    }
}
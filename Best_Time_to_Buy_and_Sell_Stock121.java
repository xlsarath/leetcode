//time complexity : O(n)
//space complexity : O(1)

public class Best_Time_to_Buy_and_Sell_Stock121 {

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        int res = 0 ; int profit = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < profit) profit = prices[i];
            else if(prices[i] - profit > res) res = prices[i] - profit;
        }
        return res;
    }

}
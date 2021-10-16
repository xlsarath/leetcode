class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sel1 = 0, sel2 = 0;
        for(int i = 0 ; i < prices.length; i++){
            buy1 = Math.min(buy1, prices[i]);
            sel1 = Math.max(sel1, prices[i]-buy1);
            buy2 = Math.min(buy2, prices[i]-sel1);
            sel2 = Math.max(sel2, prices[i]-buy2);
        }
        return sel2;
    }
}
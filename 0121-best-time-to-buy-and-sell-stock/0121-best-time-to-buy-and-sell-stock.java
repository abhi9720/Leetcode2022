class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit =0;
        int buy = prices[0];
        for(int i=1;i<prices.length;i++){
            buy =  Math.min(buy , prices[i] );
            maxProfit =  Math.max(maxProfit , prices[i] -  buy)     ;           
        }
        return maxProfit;
    }
}
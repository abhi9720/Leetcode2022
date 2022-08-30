class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n  =  prices.length;
        int buy[] =  new int[n];
        int sell[]  =  new int[n];
        // if we buy something that means we have spend that amount of money
        buy[0] =  -prices[0];
        sell[0] =  0;
        for(int i=1;i<n;i++){
            buy[i] = Math.max(buy[i-1] , sell[i-1] - prices[i]);
            sell[i] =  Math.max( buy[i-1] +prices[i]-fee, sell[i-1]     );
        }
        
        return sell[n-1];
        
        
    }
}
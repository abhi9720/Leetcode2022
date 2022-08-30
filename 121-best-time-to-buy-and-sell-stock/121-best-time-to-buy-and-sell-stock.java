class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int buy = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }
}

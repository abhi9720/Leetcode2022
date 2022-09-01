class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k == 0 || n == 0) {
            return 0;
        }
        int dp[][] = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            // for (int j = 1; j < n; j++) {
            //     int max = dp[i][j - 1];
            //     for (int jj = 0; jj < j; jj++) {
            //         max = Math.max(max, dp[i - 1][jj] + prices[j] - prices[jj]);
            //     }
            //     dp[i][j] = max;
            // }
            int maxP =  Integer.MIN_VALUE;
            for(int j =  1;j<n;j++){
                maxP =  Math.max(maxP , dp[i-1][j-1] -  prices[j-1]);
                dp[i][j] =  Math.max(maxP + prices[j] , dp[i][j-1] );
            }
        }

        return dp[k][n - 1];
    }
}

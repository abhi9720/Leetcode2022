class Solution {

    public int coinChange(int[] coins, int amount) {
        //         int amt[]  =  new int[amount+1];
        //         // amt[i] = minimum number of coins require to make amount i

        //         for(int i=1;i<=amount;i++){
        //             int minCoins = -1;

        //             // making ith amount using all coins
        //             for(int coin : coins ){
        //                 if( coin <= i  && amt[i-coin]!=-1 ){
        //                     int req =  amt[i-coin]+1;
        //                     minCoins =  minCoins<0?req:Math.min(minCoins,req);
        //                 }
        //             }
        //             amt[i] = minCoins;
        //         }
        //      return amt[amount];
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = 10001;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        

        return dp[n][amount] >= 10001 ? -1 : dp[n][amount];
    }
}

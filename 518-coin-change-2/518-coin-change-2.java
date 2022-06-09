class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (coins[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                        // number of ways to make amount j using  i number of coins
                        // =  number of ways to make j amount without using ith coint , i-1
                        // + number of ways to make j-coins[i] amount if i am using ith coins
                    }
                }
            }
        }
        
        return dp[n][amount];
    }
}

public class Solution {
public int coinChange(int[] coins, int amount) {
    if(amount<1) return 0;
    int[] dp = new int[amount+1];
    int sum = 0;
    // dp[i] means minimum coins required to make amount i , 
    // then using dp[i] , we can calculate dp[i+1] , using all coins 
    // starting from sum =1 ; means minimum coins required to make amount 1
	while(++sum<=amount) {
		int min = -1;
    	for(int coin : coins) {
    		if(sum >= coin && dp[sum-coin]!=-1) {
    			int temp = dp[sum-coin]+1;
                // if min== -1 then fill temp otherwise compare , minimum(min,temp)
    			min = min<0 ? temp : Math.min(temp,min);
    		}
    	}
    	dp[sum] = min;
	}
	return dp[amount];
    }
}
// MCM PATTERN 

class Solution {
    int dp[][] = new int[302][302];

    public int maxCoins(int[] nums) {
        for (int rows[] : dp) {
            Arrays.fill(rows, -1);
        }
        return findCost(nums, 0, nums.length - 1);
    }

    private int findCost(int nums[], int left, int right) {
        int n  =  nums.length;
        if (left > right) return 0;
        if (dp[left][right] != -1) return dp[left][right];
        int maxProfit = 0;
        for (int k = left; k <= right; k++) {
            int p1 = findCost(nums, left, k - 1);
            int p2 = findCost(nums, k + 1, right);
            int p = (left - 1 == -1 ? 1 : nums[left - 1]) * nums[k] * (right + 1 == n ? 1 : nums[right + 1]);
            maxProfit =  Math.max(maxProfit , p1+p2+p);
        }
        return dp[left][right] =  maxProfit;
    }
}

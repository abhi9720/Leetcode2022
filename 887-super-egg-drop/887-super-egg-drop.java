class Solution {
    int dp[][];

    public int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(k, n);
    }

    private int solve(int e, int f) {
        if (f == 0 || f == 1) {
            return dp[e][f] = f;
        }
        if (e == 1) {
            return dp[e][f] = f;
        }
        if (dp[e][f] != -1) return dp[e][f];
        int min=0;
        // for (int k = 2; k <= f; k++) {
        //     int temp = 1 + Math.max(
        //         dp[e - 1][k - 1] != -1 ? dp[e - 1][k - 1] : solve( e - 1, k - 1),
        //         dp[e][f - k] != -1 ? dp[e][f - k] : solve(e, f - k));
        //     min = Math.min(temp, min);
        // }

        // using binary search instead of linear traversal
        int lo = 1, hi = f;
        while (lo +1 < hi) {
            int mid = (hi + lo) / 2 ;
            int t1 = solve(e - 1, mid - 1);
            int t2 = solve(e, f - mid);
            if (t1 < t2) {
                lo = mid;
            } else if (t1 > t2) {
                hi = mid;
            } else {
                lo = hi = mid;
            }

            
        }
        
        int temp1 = Math.max(solve(e - 1, lo - 1), solve(e, f - lo));
            int temp2 = Math.max(solve(e - 1, hi - 1), solve(e, f - hi));
            min = 1 + Math.min(temp1, temp2);

        dp[e][f] = min;
        return dp[e][f];
    }
}

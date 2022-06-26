class Solution {
    Integer dp[][];

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        dp = new Integer[m][m];
        
        return (int)cost(nums,multipliers,0,n-1,0);
        
    }

    private int cost(int nums[], int mult[], int i, int j, int itr) {
        if (itr >= mult.length || i > j) return 0;
        if (dp[i][itr] != null) return dp[i][itr];

        int op1 = cost(nums, mult, i + 1, j, itr + 1) + nums[i] * mult[itr];
        int op2 = cost(nums, mult, i, j - 1, itr + 1) + nums[j] * mult[itr];
        
        return dp[i][itr] = Math.max(op1, op2);
    }
}


// class Solution {
//     int n, m;
//     int[] nums, muls;
//     Integer[][] memo;
//     public int maximumScore(int[] nums, int[] muls) {
//         n = nums.length;
//         m = muls.length;
//         this.nums= nums;
//         this.muls = muls;
//         this.memo = new Integer[m][m];
//         return dp(0, 0);
//     }
//     private int dp(int l, int i) {
//         if (i == m) return 0; // Picked enough m elements
//         if (memo[l][i] != null) return memo[l][i];
//         int pickLeft = dp(l+1, i+1) + nums[l] * muls[i]; // Pick the left side
//         int pickRight = dp(l, i+1) + nums[n-(i-l)-1] * muls[i]; // Pick the right side
//         return memo[l][i] = Math.max(pickLeft, pickRight);
//     }
// }
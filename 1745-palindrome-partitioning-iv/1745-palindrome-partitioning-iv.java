class Solution {
    boolean dp[][];

    public boolean checkPartitioning(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        precomputeAllpalindrome(s);
        
        
        for (int i = 0; i < n - 2; i++) {
            if (dp[0][i]) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (dp[i + 1][j] && dp[j + 1][n - 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void precomputeAllpalindrome(String str) {
        int n = str.length();
     
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = i + gap; j < n && i < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) && dp[i + 1][j - 1];
                }
            }
        }
    }
}

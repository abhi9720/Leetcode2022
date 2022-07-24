class Solution {

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (j == 0) {
                    dp[i][j] = false;
                } else if (i == 0) {
                    char pc = p.charAt(j - 1);
                    if (pc == '*') {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else {
                    char pc = p.charAt(j - 1);
                    char sc = s.charAt(i - 1);

                    if (pc == sc || pc == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == '*') {
                        dp[i][j] = dp[i - 1][j]  || dp[i][j-1];
                        
                        
                    }
                }
            }
        }

        return dp[n][m];
    }
}

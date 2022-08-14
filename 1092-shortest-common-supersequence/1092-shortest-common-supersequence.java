class Solution {

    public String shortestCommonSupersequence(String x, String y) {
        int n = x.length();
        int m = y.length();

        int dp[][] = dynamic(x, y);
        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sb.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                int val1 = dp[i - 1][j], val2 = dp[i][j - 1];

                if (val1 < val2) {
                    sb.append(x.charAt(i - 1));
                    i--;
                } else {
                    sb.append(y.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i > 0) {
            sb.append(x.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(y.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    private static int[][] dynamic(String x, String y) {
        int n = x.length();
        int m = y.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] =  1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }
}

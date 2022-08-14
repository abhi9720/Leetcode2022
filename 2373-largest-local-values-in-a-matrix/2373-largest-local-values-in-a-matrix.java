class Solution {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n - 2][m - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                // for every i,j genrate 3*3 size sub matrix
                int max = grid[i][j];
                for (int xx = i; xx < i + 3 && xx < n; xx++) {
                    for (int yy = j; yy < j + 3 && yy < m; yy++) {
                        max = Math.max(max, grid[xx][yy]);
                    }
                }
                ans[i][j] = max;
            }
        }
        return ans;
    }
}

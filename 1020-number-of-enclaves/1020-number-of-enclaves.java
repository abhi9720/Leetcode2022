class Solution {
    int ans, res;

    public int numEnclaves(int[][] grid) {
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = 0;
                res = 1;
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, grid.length, grid[0].length);
                    if (res == 0) cnt += 0; else cnt += ans;
                 
                }
            }
        }
        return cnt;
    }

    void dfs(int[][] grid, int row, int col, int m, int n) {
        if (row >= m || row < 0 || col >= n || col < 0 || grid[row][col] == 0) return;
        if ((row == m - 1 || row == 0 || col == n - 1 || col == 0) && grid[row][col] == 1) {
            res = 0;
        }
        ans += 1;
        grid[row][col] = 0;
        dfs(grid, row + 1, col, m, n);
        dfs(grid, row, col + 1, m, n);
        dfs(grid, row, col - 1, m, n);
        dfs(grid, row - 1, col, m, n);
    }
}

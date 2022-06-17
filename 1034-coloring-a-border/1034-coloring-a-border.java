class Solution {

    public int[][] colorBorder(int[][] grid, int r, int c, int color) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[r][c] == color) return grid;

        boolean[][] visited = new boolean[n][m];
        dfs(grid, r, c, grid[r][c], visited, color, n, m);

        return grid;
    }

    public void dfs(int[][] grid, int i, int j, int col, boolean[][] visited, int target, int n, int m) {
        if (i > n - 1 || i < 0 || j > m - 1 || j < 0 || grid[i][j] != col || visited[i][j]) return;

        visited[i][j] = true;
        boolean border = false;

        if (i == 0 || j == 0 || j == m - 1 || i == n - 1 
            || grid[i + 1][j] != col || grid[i - 1][j] != col || 
            grid[i][j - 1] != col || grid[i][j + 1] != col) border = true;

        dfs(grid, i + 1, j, col, visited, target, n, m);
        dfs(grid, i - 1, j, col, visited, target, n, m);
        dfs(grid, i, j + 1, col, visited, target, n, m);
        dfs(grid, i, j - 1, col, visited, target, n, m);

        if (border) grid[i][j] = target;
    }
}

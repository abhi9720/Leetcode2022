class Solution {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int  m =  grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    int dir[][] = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    void dfs(char grid[][], boolean visited[][], int i, int j) {
        int n  =  grid.length;
        int m  =  grid[0].length;
        visited[i][j] = true;
        for (int d[] : dir) {
            int nx = d[0] + i;
            int ny = d[1] + j;
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny]=='1' && 
               !visited[nx][ny]) {
                dfs(grid,visited,nx,ny);
            }
        }
    }
}

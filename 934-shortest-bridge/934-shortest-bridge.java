class Solution {

    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> border = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j, border);
                    break;
                }
            }
            if (border.size() != 0) break;
        }
        

        int dis = 0;
        int dirs[][] = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };        
        while (border.size() > 0) {
            int size = border.size();
            while (size-- > 0) {
                int p[] = border.remove();
                
                // we have to avoid checking for first island 1, so we change them to 2 
                // as they went visited by dfs call
                if (visited[p[0]][p[1]] && grid[p[0]][p[1]]!=2) continue;
                
                
                visited[p[0]][p[1]] = true;
                if (grid[p[0]][p[1]]==1) return dis-1;

                for (int d[] : dirs) {
                    int x = d[0] + p[0];
                    int y = d[1] + p[1];
                    if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y]) {                    
                        border.offer(new int[] { x, y });
                    }
                }
            }
            dis++;
        }

        return dis-1;
    }

    private void dfs(int grid[][], boolean visited[][], int i, int j, Queue<int[]> border) {
        int n = grid.length, m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] == 0) return;

        visited[i][j] = true;
        dfs(grid, visited, i, j - 1, border);
        dfs(grid, visited, i, j + 1, border);
        dfs(grid, visited, i + 1, j, border);
        dfs(grid, visited, i - 1, j, border);
        
        
        if (i == 0 || j == 0 || i == n - 1 || j == m - 1 || grid[i][j - 1] == 0 || grid[i - 1][j] == 0 || grid[i][j + 1] == 0 || grid[i + 1][j] == 0) {
            border.add(new int[] { i, j });
            grid[i][j] =  2;
        }

    }
}

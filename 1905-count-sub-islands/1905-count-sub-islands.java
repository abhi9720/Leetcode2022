class Solution {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        boolean visit1[][] = new boolean[n][m];
        boolean visit2[][] = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && !visit2[i][j] && grid1[i][j] == 1 && !visit1[i][j]) {
                    int val = dfs(grid1, grid2, visit1, visit2, i, j);
                    if(val==0){
                        dfs_markZero(grid2,i,j);
                    }
                    else{
                        count += val;                        
                    }
                    
                }
            }
        }
        return count;
    }

    int dir[][] = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    int dfs(int grid1[][], int grid2[][], boolean[][] visit1, boolean[][] visit2, int i, int j) {
        int n = grid1.length;
        int m = grid1[0].length;
        visit1[i][j] = true;
        visit2[i][j] = true;

        for (int d[] : dir) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (grid2[nx][ny] == 1 && !visit2[nx][ny]) {
                    if (grid1[nx][ny] == 0 || visit1[nx][ny]) return 0;
                    int val = dfs(grid1, grid2, visit1, visit2, nx, ny);
                    if (val == 0) return 0;
                }
            }
        }
        return 1;
    }

    void dfs_markZero(int grid[][], int i, int j) {
        int n  =  grid.length;
        int m  =  grid[0].length;
        // makr whole component 0
        grid[i][j] = 0;
        for (int d[] : dir) {
            int nx = i + d[0];
            int ny = j + d[1];
            if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==1){
                dfs_markZero(grid,nx,ny);
            }                
        }
    }
}

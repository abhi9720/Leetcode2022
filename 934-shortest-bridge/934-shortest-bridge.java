class Solution {

    public class Pair {
        int i;
        int j;
        int lev;

        Pair(int i, int j, int lev) {
            this.i = i;
            this.j = j;
            this.lev = lev;
        }
        
    }

    public int shortestBridge(int[][] grid) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        boolean[][] vis1 = new boolean[grid.length][grid[0].length];
        boolean found = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, vis1, q, i, j);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        
        
        
        
        int dist = -1;
        boolean[][] vis2 = new boolean[grid.length][grid[0].length];
        while (q.size() > 0) {
            Pair rem = q.remove();

            if (vis2[rem.i][rem.j]) {
                continue;
            }
            

            vis2[rem.i][rem.j] = true;

            if (grid[rem.i][rem.j] == 1) {
                return rem.lev - 1;
            }
            
            
            addNbr(grid, vis2, q, rem.i, rem.j + 1, rem.lev + 1);
            addNbr(grid, vis2, q, rem.i, rem.j - 1, rem.lev + 1);
            addNbr(grid, vis2, q, rem.i + 1, rem.j, rem.lev + 1);
            addNbr(grid, vis2, q, rem.i - 1, rem.j, rem.lev + 1);
            
            
        }
        return dist;
    }

    public void dfs(int[][] grid, boolean[][] vis1, ArrayDeque<Pair> q, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis1[i][j] == true || grid[i][j] == 0) return;

        vis1[i][j] = true;
        q.add(new Pair(i, j, 0));
        dfs(grid, vis1, q, i + 1, j);
        dfs(grid, vis1, q, i - 1, j);
        dfs(grid, vis1, q, i, j + 1);
        dfs(grid, vis1, q, i, j - 1);
        grid[i][j] = 2;
    }

    public void addNbr(int[][] grid, boolean[][] vis2, ArrayDeque<Pair> q, int i, int j, int lev) {
        if (i < 0 || j < 0 || i >= grid.length ||
            j >= grid[0].length || vis2[i][j] == true || grid[i][j] == 2) {
            return;
        }
        q.add(new Pair(i, j, lev));
    }
}

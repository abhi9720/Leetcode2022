class Solution {

    public int maxDistance(int[][] grid) {
        // start bfs from land point
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int count0=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[] { i, j });
                }
                else{
                    count0++;
                }
            }
        }
        if(count0==0) return -1;

        int dis = -1;        
        int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int peek[] = q.remove();
                int x = peek[0], y = peek[1];                                
                for (int d[] : dir) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 0 ) 
                    {
                        q.offer(new int[] { nx, ny });
                        grid[nx][ny] =  1;
                    }
                }
            }
            dis++;
        }
        return dis;
    }
}

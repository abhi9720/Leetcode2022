class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                }
            }
        }

        int ans[][] = new int[mat.length][mat[0].length];
        for(int row [] : ans){
            Arrays.fill(row,-1);
        }
        
        int dist = 0;
        int dirs[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int peek[] = q.poll();
                int x = peek[0], y = peek[1];                
                if(ans[x][y] !=-1 ) continue;            
                ans[x][y] = dist;
                // get its all nbr which are one
                for (int d[] : dirs) {
                    int nx = d[0] + x, ny = d[1] + y;
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && mat[nx][ny] == 1) {
                        q.offer(new int[] { nx, ny });
                    }
                }
            }
            dist++;
        }
        return ans;
    }
}

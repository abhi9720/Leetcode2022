class Solution {

    int dir[][] =  {{-1,0},{1,0},{0,1},{0,-1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b)->a[2]-b[2] );
        pq.offer(new int[] { 0, 0, grid[0][0] });
        boolean visited[][] =  new boolean[n][m];
        int time = grid[0][0];
        while (pq.size() > 0) {
            int p[] = pq.remove();
            int x = p[0], y = p[1], t = p[2];                        
            time  =  Math.max(t,time);
            if(x==n-1 && y==m-1) break;
            if(visited[x][y]) continue;
            visited[x][y] =  true;
            for(int d[] : dir){
                int nx =  x+d[0] , ny =  y+d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    pq.offer( new int[]{nx,ny,grid[nx][ny]} );
                }
            }            
        }
        return time;
    }
}

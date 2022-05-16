class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1 ) return -1;
        int n  =  grid.length, m =  grid[0].length;
        int dir[][]  = {{-1,0},{0,1},{0,-1},{1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        boolean visited[][] =  new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        while(q.size() >0 ){
            int temp[] =  q.remove();
            int x =  temp[0],  y =  temp[1] , cost = temp[2];
            if(visited[x][y] ) continue;
            visited[x][y] =  true;
            if(x==n-1 && y==m-1) return cost;
            
            
            for(int d[] : dir){
                int nx =  d[0]+x , ny =  d[1]+y;
                if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==0 && !visited[nx][ny]  ){
                    if(nx==n-1 && ny==m-1) return cost+1;
                    q.add(new int[]{nx,ny,cost+1});
                }
            }
        }
        return -1;
    }
}
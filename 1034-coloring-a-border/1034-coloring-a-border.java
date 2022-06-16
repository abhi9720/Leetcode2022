class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n  =  grid.length,m = grid[0].length;            
        int ans[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] =  grid[i][j];
            }
        }
        // start doing bfs from point of orgin 
        Queue<int[]> q  =  new ArrayDeque<>();
        q.offer(new int[]{row,col});
        
        
        boolean visited[][] =  new boolean[n][m];
        int cc  =  grid[row][col];
        int dirs[][] =  {{-1,0},{0,1},{0,-1},{1,0}};
        while(q.size()!=0 ){
            int p[] =  q.remove();
            if(visited[p[0]][p[1]] ) continue;
            visited[p[0]][p[1]] =  true;
            if(isBorder(grid,p[0],p[1],grid[p[0]][p[1]])){                                
                ans[p[0]][p[1]] =  color;
            }
            for(int d[] : dirs){
                int x =  d[0]+p[0];
                int y =  d[1]+p[1];;                
                if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==cc){
                    q.offer(new int[]{x,y});
                }
            }                                    
        }
        
        return ans;
        
    }
    
    private boolean isBorder(int grid[][], int i, int j , int ele){
        int n  =  grid.length,m = grid[0].length;            
        // check left 
        if( j-1<0 || (j-1>=0 && grid[i][j-1]!=ele)  ) return true;        
        // check right
        if( j+1==m || (j+1<m && grid[i][j+1]!=ele)  ) return true;
        // check top
        if( i-1<0 || (i-1>=0 && grid[i-1][j]!=ele) ) return true;
        // check bottom
        if( i+1==n || (i+1<n && grid[i+1][j]!=ele) ) return true;
        
        return false;
    }
    
}
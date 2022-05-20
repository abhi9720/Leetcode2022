class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0]==1 ) return 0;
        int n =  grid.length  , m =  grid[0].length;
        int path[][] =  new int[n][m];
        for(int rows[] : path){
            Arrays.fill(rows,-1);
        }
        return dfs_memo(grid,path,0,0);
    }
    // 
    int dir[][] =  {{1,0},{0,1}};
    private int dfs_memo(int grid[][],int path[][], int i , int j){
        int n  =  grid.length , m =  grid[0].length;
        if(i==n-1 && j == m-1){
            return 1;
        }
        
        if( path[i][j]!=-1  ){
            return path[i][j];
        }
        
        int count = 0;
        for(int d[] : dir){
            int nx =  i+d[0] , ny =  j+d[1];
            if(nx>=0 && ny>=0 && nx<n && ny < m && grid[nx][ny]==0 ){
                count+=dfs_memo(grid,path,nx,ny);
            }
        }
        
        return path[i][j]=count;
    }
}
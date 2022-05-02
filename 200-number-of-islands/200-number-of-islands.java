class Solution {
    public int numIslands(char[][] grid) {
        int n  =  grid.length,m =  grid[0].length;
        boolean visited[][] =  new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false && grid[i][j]=='1' ){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }            
        return count;
    }
    static int dir[][]  =  {{-1,0},{1,0},{0,1},{0,-1}};
    
    private void dfs(char grid[][],int i, int j,boolean visited[][]){
        int n  = grid.length;
        int m  =  grid[0].length;
        
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0' || visited[i][j]==true ){
            return;
        }
        
        
        visited[i][j] =  true;
        for(int d[]:dir){
            int newx =  i+d[0], newy =  j+d[1];            
            dfs(grid,newx,newy,visited);
        }
        
        
        
    }
}
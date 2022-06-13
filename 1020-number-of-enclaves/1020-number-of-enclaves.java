class Solution {
    int dir[][] = { {0,1},{0,-1},{-1,0},{1,0}};

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int count = 0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (i == 0 || j == 0) continue;
                if (grid[i][j] == 1 && !visited[i][j]) {
                    
                    int val = helper(grid, visited, i, j);
                    if(val!=-1) count+=val;                        
                }
            }
        }
        return count;
    }

    private int helper(int grid[][], boolean visited[][], int i, int j) {
        int n = grid.length,m = grid[0].length;
        
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0 || visited[i][j] ) return 0;        
        if(grid[i][j]==1 && (i==0 || j==0 || i==n-1 || j==m-1 )) return -1;
        int count = 0;
        
        visited[i][j] =  true;
        for(int d[] : dir ){
            int x = i+d[0], y = j+d[1];                                 
            int val =  helper(grid,visited,x,y);            
            
            if(val==-1){visited[i][j]=false; return -1;}
            count+=val;
        }
        
        return count+1;
        
    }
}

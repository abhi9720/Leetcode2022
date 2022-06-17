class Solution {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        help(grid, row, col,grid[row][col], color, visit);
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) grid[i][j] = color;
            }
        }
        
        return grid;
    }

    public void help(int[][] grid, int row, int col,int selfcolor, int color, boolean[][] visit) {
       if(row<0 || col<0 || row>=grid.length || col>=grid[0].length|| visit[row][col]
          || grid[row][col]==0
          || grid[row][col]!=selfcolor
         ){
           return;
       }
        
        grid[row][col] = -grid[row][col];
        visit[row][col] = true;
        
        
        help(grid, row - 1, col,selfcolor, color, visit);
        help(grid, row, col - 1,selfcolor, color, visit);
        help(grid, row + 1, col,selfcolor, color, visit);
        help(grid, row, col + 1,selfcolor, color, visit);
        
        if (
            row>0 && col>0 && row<grid.length-1 && col<grid[0].length-1 &&
            Math.abs(grid[row - 1][col]) == selfcolor &&
            Math.abs(grid[row + 1][col]) == selfcolor &&
            Math.abs(grid[row][col + 1]) == selfcolor &&
            Math.abs(grid[row][col - 1]) == selfcolor
        ) {
            grid[row][col] = -grid[row][col] ;
        }
    }
     
}
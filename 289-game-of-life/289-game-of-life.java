class Solution {
    public void gameOfLife(int[][] grid) {
        int n =  grid.length, m =  grid[0].length;
        for(int i=0;i<n;i++){
            for(int j= 0;j<m;j++){
                int nbh =  getCount(grid,i,j);
                
                if(grid[i][j]==1  ){                    
                    if(nbh<2) grid[i][j] =  -2;// under 
                    else if(nbh > 3) grid[i][j] =  -2; // over                     
                }else{
                   
                    if(nbh==3) grid[i][j] =  -1;
                }                    
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j= 0;j<m;j++){
                if(grid[i][j]==-2 ) grid[i][j] =  0;
                else if(grid[i][j]==-1) grid[i][j] =  1;
            }
        }
        
        
        
    }
    private int getCount(int [][]grid , int i, int j){
        int dirs[][] =  {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
        int count = 0;
        for(int dir[] :dirs){
            int x =  i+dir[0],   y =  j+dir[1];
            if( isValid(grid,x,y) && (grid[x][y] == 1  || grid[x][y]==-2) ){
                count++;                
            }                        
        }
        return count;        
    }
    
    private boolean isValid(int grid[][], int i , int j){
        int n =  grid.length, m =  grid[0].length;
        return i>=0 && i<n && j>=0 && j<m;
    }
        

}
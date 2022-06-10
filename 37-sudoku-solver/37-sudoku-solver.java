class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
        
    }
    private boolean helper(char [][]board, int i , int j ){
        int n  = board.length ;
        if(i==n)  {            
            return true;
        }
            
        
        int new_j = j==n-1?0:j+1;
        int new_i = j==n-1?i+1:i;
        
        // System.out.println(board+"["+i+" , "+j+"]");
        if(board[i][j]!='.' ){            
            return helper(board,new_i,new_j);
            
        }
        
        for(char num='1';num<='9';num++){            
            if(canPlace(board,i,j,num) ){
                board[i][j] =  num;
                if(helper(board,new_i,new_j)) return true;
                board[i][j] =  '.';
            }
        } 
        return false;
    }
    
    private boolean canPlace(char grid[][], int i, int j ,char n ){
        int x1 =  i-i%3;
        int y1 =  j-j%3;
        for(int x = x1;x<=x1+2;x++){
            for(int y=y1;y<=y1+2;y++){
                if(grid[x][y]== n ) return false;
            }
        }
        
        for(int y=0;y<grid.length;y++ ){
            if(grid[i][y]==n ) return false;
        }
        for(int x=0;x<grid.length;x++){
            if(grid[x][j]==n ) return false;
        }
        return true;
    }
}
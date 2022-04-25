class Solution {
     char mat[][] ;
    public void solveSudoku(char[][] board) {
        solveSudoku(board,0,0);
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board.length;y++){
                   board[x][y]=mat[x][y];
            }
        }
        
    }
    
    
    public  void solveSudoku(char[][] board, int i, int j) {
    
    if(i==board.length){
        mat = new char[board.length][board.length];
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board.length;y++){
                mat[x][y] =  board[x][y];
            }
        }
        
        return;
        
    }
    
    // for current i,j find its submatrix
    
    
    int n  =  board.length;
     int newY = j==n-1?0:j+1;
     int newX = j==n-1?i+1:i;
    
    if(board[i][j]!=46){        
        solveSudoku(board,newX,newY );
        return;
    }
    
   
    for(char num='1';num<='9';num++){
        if(isSafe(board,i,j,num) ){
            board[i][j] =  num;
            solveSudoku(board,newX,newY );
            board[i][j] =  '.';
        }
    }
  }
    
    private static boolean isSafe(char[][] board , int i ,int j,char num){
        int x1 =  i-i%3, x2  =  x1+2;
        int y1 =  j-j%3, y2  =  y1+2;

        // System.out.println("num  : "+num );
        for(int x= x1;x<=x2;x++){
            for(int y=y1;y<=y2;y++){
                if(board[x][y] == num ){
                    // System.out.println("{"+x+" "+y+"} used   : "+board[x][y] );
                    return false;
                }
            }
        }
        // check column 
        for(int x=0;x<board.length;x++){
            if(board[x][j]==num){ 
                // System.out.println("{"+x+" "+j+"} used   : "+board[x][j] );
                return false;}
        }
        //check row 
        for(int y=0;y<board.length;y++){
            if(board[i][y]==num ){
                // System.out.println("{"+i+" "+y+"} used   : "+board[i][y] );
                return false;
            }
        }
        return true;
    }
}
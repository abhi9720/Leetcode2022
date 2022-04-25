class Solution {
     
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
       
    }
    
    
    public  boolean solveSudokuHelper(char[][] board) {
    
    for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isSafe(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solveSudokuHelper(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;      
  }
    
    private static boolean isSafe(char[][] board , int i ,int j,char num){
        int x1 =  i-i%3, x2  =  x1+2;
        int y1 =  j-j%3, y2  =  y1+2;

        // System.out.println("num  : "+num );
        for(int x= x1;x<=x2;x++){
            for(int y=y1;y<=y2;y++){
                if(board[x][y] == num ){
                    return false;
                }
            }
        }
        // check column 
        for(int x=0;x<board.length;x++){
            if(board[x][j]==num){ 
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
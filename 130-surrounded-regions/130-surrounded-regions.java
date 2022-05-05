class Solution {
    public void solve(char[][] board) {
        
        
        // mark all border side O to * then turn all O to x
        
        int n   =  board.length;
        int m  =  board[0].length;
        
        
        for(int i=0;i<n;i++){ // iterate row 
            if(board[i][0]=='O'){
              dfs(board,i,0)  ;
            } 
            if(board[i][m-1]=='O'){
                dfs(board,i,m-1);
            }            
        }
        
        for(int j=0;j<m;j++){ // iterate col
            if(board[0][j]=='O'){
                dfs(board,0,j);
            } 
            if(board[n-1][j]=='O'){
                dfs(board,n-1,j);
            }
        }
        
        // till this point we change all O to * , which are on bouandary , or
        // comes  in contact to boundary O
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j] =  'X';
                }
                else if(board[i][j]=='*'){
                    board[i][j] =  'O';
                }
            }
        }
                                
    }
    
    
    int dir[][] =  {{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(char board[][], int i , int j){
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return ;   
        int n =  board.length, m = board[0].length;
        if(board[i][j]=='O'){
            board[i][j] =  '*';
        }
        
         for(int d[] : dir){
            int newx =  i+d[0];
            int newy = j+d[1];
            if(newx>=0 && newy>=0 && newx<n && newy<m && board[newx][newy]=='O'){
                dfs(board,newx,newy);
            }
        }
        
        
       
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
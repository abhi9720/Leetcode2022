class Solution {
    public int totalNQueens(int n) {           
        boolean marked[][] =  new boolean[n][n];                          
        return placeQueen(marked,0);
          
    }
    
    public static int placeQueen(boolean marked[][],int row){
        int n =  marked.length;
        if(n==row){            
            return 1;
        }      
        
        int count  = 0;
        // check for  current row for placing
        for(int c=0;c<n;c++){
            if(canPlaced(marked,row,c ) ){
                marked[row][c]=true;
                // make  call for next row                
                count+=placeQueen(marked,row+1);
                // and also backtrack
                marked[row][c]=false;                
            }
        }
        return count;            
    }
   
    
    public static boolean canPlaced(boolean marked[][],int i , int j){
        int n =  marked.length;
        // move vertical up
        for(int r=i;r>=0;r--){
            if(marked[r][j]) return false; // cannot place
        }
                
        // move left diagonal up
        for(int r=i,c=j;r>=0 && c>=0;r--,c--){
            if(marked[r][c]) return false; // cannot place
        }
        
        // move right diagonal up
        for(int r=i,c=j;r>=0 && c<n;r--,c++){
            if(marked[r][c]) return false; // cannot place
        }
        
        // all clear then return true
        return true;
    }
    
    
    
}
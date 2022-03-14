class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean marked[][] =  new boolean[n][n];  
        List<List<String>> ans =  new ArrayList<>();
        List<String> way =  new ArrayList<>();
                
        placeQueen(marked,ans,way,0);
        return ans;        
    }
    
    public static void placeQueen(boolean marked[][], List<List<String>>ans, List<String>way, int row){
        int n =  marked.length;
        if(n==row){
            ans.add(new ArrayList(way) );
            return;
        }
        // System.out.println("row  : "+row);
        // System.out.println(ans);
        // System.out.println(way);
        
        // check for  current row for placing
        for(int c=0;c<n;c++){
            if(canPlaced(marked,row,c ) ){
                marked[row][c]=true;
                // make  call for next row
                String placestr =  placeString(marked,row);
                way.add(placestr);
                placeQueen(marked,ans,way,row+1);
                // and also backtrack
                marked[row][c]=false;
                way.remove(way.size()-1 );
            }
        }
            
        
        
    }
    private static String placeString(boolean marked[][],int row){
        int n =  marked.length;
        StringBuilder sb =  new StringBuilder();
        for(int c=0;c<n;c++){
            if(marked[row][c]){
                sb.append("Q");
            }
            else{
                sb.append(".");
            }
        }
        return sb.toString();
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
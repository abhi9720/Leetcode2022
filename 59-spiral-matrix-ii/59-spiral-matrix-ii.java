class Solution {
    public int[][] generateMatrix(int n) {
        
        int data = 1;
        int ans[][]  =  new int[n][n];        
        int i1 =  0 , i2 =  n-1, j1 =  0 , j2 = n-1;
        
        while( data<=n*n ){
            for( int x = i1,y = j1; x<=i2 && y<=j2 && data<=n*n; y++ ){
                ans[x][y] =  data;
                data++;                
            }
            i1++;
            
            for(int x = i1,y=j2;x<=i2 && y>=j1 ;x++ ){
                ans[x][y] =  data;
                data++;
            }
            j2--;
            
            
            for(int x = i2,y=j2; x>=i1 && y>=j1 && data<=n*n;y-- ){
                ans[x][y] =  data;                
                data++;
            }
            i2--;
            
            for(int x = i2, y = j1 ; x>=i1 && y<=j2 && data<=n*n;x--  ){
                ans[x][y] =  data;                
                data++;                
            }    
            j1++;
        }
        return ans;
        
    }
}
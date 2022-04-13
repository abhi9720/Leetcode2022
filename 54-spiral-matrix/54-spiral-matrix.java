class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans =  new ArrayList<>();
        int count = 0 , n =  matrix.length, m =  matrix[0].length;
        int i1 =  0 , i2 =  n-1 , j1 =  0, j2 = m-1;
        while(count<n*m){
            for(int x =  i1 , y =  j1 ; x<=i2 && y<=j2 && count<n*m;y++){
                ans.add( matrix[x][y] );
                count++;
            }
            i1++;
            
            for(int x =  i1,y=j2;x<=i2 && y>=j1 && count<n*m;x++ ){
                ans.add( matrix[x][y] );
                count++;
            }
            j2--;
            
            for(int x =  i2,y =  j2;x>=i1 && y>=j1 && count<n*m;y--){
                ans.add( matrix[x][y] );
                
                count++;
            }
            i2--;
            
            for(int x = i2,y=j1 ; x>=i1 && y<=j2 && count<n*m;x--){
                ans.add( matrix[x][y] );
                count++;
            }
            j1++;
            
        }
        return ans;
            
        
    }
}
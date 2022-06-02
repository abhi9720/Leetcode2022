class Solution {
    public int[][] transpose(int[][] matrix) {
        int n  =  matrix.length, m =  matrix[0].length;
        if(n==m){
            
            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){                    
                    int t =  matrix[i][j];
                    matrix[i][j] =matrix[j][i]; 
                    matrix[j][i] =  t;                    
                }			
            }     
            return matrix;
        }
        else{
            int grid[][] =  new int[m][n];
            for(int j=0;j<m;j++){
                for(int i=0;i<n;i++){
                    grid[j][i] =  matrix[i][j];
                }
            }
            return grid;
        }
    }
}
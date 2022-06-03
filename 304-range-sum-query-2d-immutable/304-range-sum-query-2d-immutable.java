class NumMatrix {
    int prefixSum[][];
    public NumMatrix(int[][] matrix) {
        int n  =  matrix.length, m =  matrix[0].length;
        this.prefixSum =  new int[n][m+1];        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){                
                prefixSum[i][j+1]  = prefixSum[i][j] + matrix[i][j];
            }
        }        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val = 0;
        
        for(int i=row1;i<=row2;i++){
           val += prefixSum[i][col2 + 1] - prefixSum[i][col1];
        }
        
        return val;
    }
}


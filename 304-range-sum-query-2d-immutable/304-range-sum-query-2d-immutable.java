class NumMatrix {
    int prefixSum[][];
    public NumMatrix(int[][] matrix) {
        int n  =  matrix.length, m =  matrix[0].length;
        prefixSum =  new int[n][m];
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=matrix[i][j];
                prefixSum[i][j]  =  sum;
            }
        }        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val = 0;
        int n  =  prefixSum.length, m =  prefixSum[0].length;
        for(int i=row1,j=col1;i<=row2;i++){
            int previousSum = j-1>=0?prefixSum[i][j-1]:i-1>=0?prefixSum[i-1][m-1]:0;
            int endSum =  prefixSum[i][col2];
            
            val+=(endSum-previousSum);
        }
        
        return val;
    }
}


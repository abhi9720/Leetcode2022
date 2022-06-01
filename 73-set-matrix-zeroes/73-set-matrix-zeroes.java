class Solution {

    /*
        1 1 1 1
        0 0 1 1
        0 1 0 1
        0 0 0 1
        for cell [3][0] =  we have to
    
    */

    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean isCol = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) isCol = true;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0]==0 ){
            for(int j=0;j<m;j++){
                matrix[0][j] = 0;
            }
        }
        
        if(isCol){
            for(int i=0;i<n;i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}

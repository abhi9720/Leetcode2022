class Solution {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int space[][] = new int[n][m];
        // make copy of this array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                space[i][j] = matrix[i][j];
            }
        }

        // now check for 0 in space
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // pick this row and this column , make it zero
                if (space[i][j] == 0) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][j] = 0;
                    }
                    for (int col = 0; col < m; col++) {
                        matrix[i][col] = 0;
                    }                    
                }
            }
        }
    }
}

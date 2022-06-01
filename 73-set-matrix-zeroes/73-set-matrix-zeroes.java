class Solution {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean rows[] = new boolean[n];
        boolean cols[] = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]==0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (rows[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            if (cols[j]) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

class NumMatrix {
    int prefixSum[][];

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        this.prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        // System.out.println(Arrays.deepToString(prefixSum));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //         for (int i = row1; i <= row2; i++) {
        //             val += prefixSum[i][col2 + 1] - prefixSum[i][col1];
        //         }
        // return val;
        // row1++;
        // row2++;
        // col1++;
        // col2++;

        int val = prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
        return val;
    }
}

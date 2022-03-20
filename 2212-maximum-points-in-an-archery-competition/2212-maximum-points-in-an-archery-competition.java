class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        int[][] M = new int[n + 1][numArrows + 1];
        
        for (int i = 0; i < n; i ++){
            aliceArrows[i] ++;
        }
        
        for (int i = 0; i <= n; i ++){
            for (int w = 0; w <= numArrows; w ++){
                if ((i == 0) || (w == 0)){
                    M[i][w] = 0;
                }else if (aliceArrows[i - 1] <= w){
                    M[i][w] = Math.max(i - 1 + M[i - 1][w - aliceArrows[i - 1]], M[i - 1][w]);
                }else{
                    M[i][w] = M[i - 1][w];
                }
            }
        }
        int max = M[n][numArrows];
        
        int[] res = new int[n];
        int w = numArrows;
        for (int i = n; i > 0 && max > 0; i --){
            if (max == M[i - 1][w]){
                continue;
            }else{
                res[i - 1] = aliceArrows[i - 1];
                max -= i - 1;
                w -= aliceArrows[i - 1];
            }
        }
        res[0] = w;
        
        return res;
    }
}
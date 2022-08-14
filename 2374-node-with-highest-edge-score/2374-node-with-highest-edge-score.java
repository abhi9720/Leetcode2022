class Solution {

    public int edgeScore(int[] edges) {
        int n = edges.length;
        long score[] = new long[n];

        for (int i = 0; i < n; i++) {
            score[edges[i]] += i;
            
        }
        
        
        int idx = 0;
        long maxScore = score[0];
        for (int i = 0; i < n; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                idx = i;
            }
        }
        return idx;
    }
}

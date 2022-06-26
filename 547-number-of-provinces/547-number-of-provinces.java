class Solution {
    int parent[], rank[];

    public int findCircleNum(int[][] connect) {
        int v = connect.length;
        parent = new int[v];
        rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        int count = v;
        // intiall are diff 
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (connect[i][j] == 1) {                    
                    if (i != j) {
                        int s1L = find(i);
                        int s2L = find(j);
                        if (s1L != s2L) { // if already union no need to call again
                            // is islands combine so count decrease by 1
                            count -= 1;
                            union(s1L, s2L);
                        }
                    }
                }
            }
        }
        return count;
    }

    private int find(int x) {
        while (x != parent[x]) x = parent[x];
        return parent[x];
    }

    private void union(int s1L, int s2L) {
        if (rank[s1L] < rank[s2L]) {
            parent[s1L] = s2L;
        } else if (rank[s1L] > rank[s2L]) {
            parent[s2L] = s1L;
        } else {
            parent[s1L] = s2L;
            rank[s2L]++;
        }
    }
}

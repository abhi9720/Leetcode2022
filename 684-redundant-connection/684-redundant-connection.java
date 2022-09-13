class Solution {
    /// in union if there is edge a edge which connecting two vertex of same set
    // then such edge form cycle
    int parent[], rank[];

    public int[] findRedundantConnection(int[][] edges) {
        int v = edges.length;
        parent = new int[v + 1];
        rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        for (int ed[] : edges) {
            int v1 = ed[0];
            int v2 = ed[1];
            int s1L = find(v1), s2L = find(v2);
            if (s1L == s2L) {
                return ed;
            }
            union(s1L, s2L);
        }
        return null;
    }

    private int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
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

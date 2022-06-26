class Solution {
    // start removing from leaf node in one connected component failed because
    // there can be cycle also , that strategy only work for tree like structure
    // which guranteey leaf nodes and we can start removing in bottom to up manner

    HashMap<Integer,Integer> parent, rank;
    int islands=0;

    public int removeStones(int[][] stones) {
        islands =0;
        parent = new HashMap<>();
        rank = new HashMap<>();

        // consider each stone as independent insland
        // if connected stone combine then count of island decrease
        // as stone can connect and reduced to one
        // ans =  total_stone  -  no_of_island

        for (int stone[] : stones) {
            union(stone[0], ~stone[1]);
        }
        return stones.length -  islands;
    }

    private int find(int x) {
        // if not present in map means first time coming
        if (!parent.containsKey(x)) {
            islands++;
            parent.put(x, x);
            return x;
        }

        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    private void union(int m1, int m2) {
        int s1L = find(m1);
        int s2L = find(m2);

        if (s1L != s2L) {
            parent.put(s1L, s2L);
            islands -= 1;
        }
    }
}

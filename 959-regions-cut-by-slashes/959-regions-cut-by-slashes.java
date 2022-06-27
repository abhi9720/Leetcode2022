class Solution {
    int parent[], rank[];

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        // char g[][]  =  new char[n][n];

        parent = new int[4 * n * n];
        rank = new int[4 * n * n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                int base = 4 * (i * n + j);

                if (ch == '/') {
                    // System.out.println("forward slash");
                    union(base, base + 3);
                    union(base + 1, base + 2);
                } else if (ch == '\\') {
                    // System.out.println("back slash");
                    union(base, base + 1);
                    union(base + 2, base + 3);
                } else {
                    // System.out.println("no slash");
                    union(base, base + 3);
                    union(base + 1, base + 2);
                    union(base, base + 2);
                }

                if (j < n - 1) {
                    // System.out.println("hori : " + (base + 1) + "  , " + (base + 7));
                    union(base + 1, base + 7); // horizontal
                }
                if (i < n - 1) {
                    // System.out.println("verti : " + (base + 2) + "  , " + ((i + 1) * n + j));
                    union(base + 2, 4 * ((i + 1) * n + j));
                }
                // System.out.println(Arrays.toString(parent));
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            parent[i] = find(i);
            set.add(parent[i]);
        }
        // System.out.println(Arrays.toString(parent));

        return set.size();
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int ele1, int ele2) {
        int s1L = find(ele1);
        int s2L = find(ele2);
        if (rank[s1L] < rank[s2L]) {
            parent[s1L] = s2L;
        } else if (rank[s2L] < rank[s1L]) {
            parent[s2L] = s1L;
        } else {
            parent[s1L] = s2L;
            rank[s2L]++;
        }
    }
}

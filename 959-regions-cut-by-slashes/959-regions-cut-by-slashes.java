class Solution {
    int parent[], rank[];

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
 
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
                    union(base, base + 3);
                    union(base + 1, base + 2);
                } else if (ch == '\\') {
                    
                    union(base, base + 1);
                    union(base + 2, base + 3);
                } else {
                    
                    union(base, base + 3);
                    union(base + 1, base + 2);
                    union(base, base + 2);
                }

                if (j < n - 1) {
                    
                    union(base + 1, base + 7); // horizontal
                }
                if (i < n - 1) {
                    //vertical union
                    union(base + 2, 4 * ((i + 1) * n + j));
                }
                
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            // count number of parent , and set lead parent is same 
            if(parent[i]==i) count++;
        }


        return count;
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

class Solution {
    int parent[], rank[];

    public int numSimilarGroups(String[] strs) {
        int count = 0;
        int n = strs.length;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    // count++;
                    int s1L = find(i);
                    int s2L = find(j);
                    if (s1L != s2L) {
                        union(s1L, s2L);
                        count++;
                    }
                }
            }
        }
        return n - count;
    }

    boolean isSimilar(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 != l2) return false;
        Set<Character> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i = 0; i < l1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                set1.add(s1.charAt(i));
                set2.add(s2.charAt(i));
            }
            if (set1.size() > 2) return false;
        }
        if (set1.size() == 0) return true;
        if (set1.size() != 2) return false;
        return set1.equals(set2);
    }

    private int find(int x) {
        while (x != parent[x]) x = parent[x];
        return parent[x];
    }

    private void union(int s1L, int s2L) {
        
        if (rank[s1L] < rank[s2L]) {
            parent[s1L] = s2L;
        } else if (parent[s2L] < rank[s1L]) {
            parent[s2L] = s1L;
        } else {
            rank[s2L]++;
            parent[s1L] = s2L;
        }
    }
}

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
        
        char diff[] =  new char[2];
        int idx = 0;
        for (int i = 0; i < l1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {                
                if(idx==0) diff[idx++] =  s1.charAt(i);
                else if(idx==1) diff[idx++] =  s2.charAt(i);
                else return false;
            }
            
        }
        // why we are not caring both other two char , they can also be mismatches
        // it is given both string are anagram , so if mismatch are 2 , 
        // then idx =2 goes to idx=-1 otherwise if more than 2 mismatch then idx<-1
        return idx!=1 && ( diff[0] == diff[1]  );
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

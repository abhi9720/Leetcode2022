class Solution {
    Queue<String> q;
    HashSet<String> visited;

    public int kSimilarity(String s1, String s2) {
        
        q = new ArrayDeque<>();
        visited = new HashSet<>();
        char ch[] = s2.toCharArray();
        q.offer(s1);
        int level = 0;
        while (q.size() != 0) {
            int size = q.size();
            while (size-- > 0) {
                String nbr = q.remove();
                if(nbr.equals(s2) ) return level;                
                if (!visited.contains(nbr)) {
                    nextString(nbr.toCharArray(), ch);
                }
                visited.add(nbr);
            }
            level++;
        }
        return level;
    }

    private void nextString(char ch1[], char ch2[]) {
        int i = 0, j = 0, k = 0;
        for (; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                j = i;
                break;
            }
        }
        char eq = ch2[j];
        i++;
        for (; i < ch1.length; i++) {
            if (ch1[i] == eq) {
                swap(ch1, j, i);
                String newstr = new String(ch1);
                if (!visited.contains(newstr)) {
                    q.offer(newstr);
                }
                swap(ch1, j, i);
            }
        }
    }

    void swap(char ch1[], int i, int j) {
        char c = ch1[i];
        ch1[i] = ch1[j];
        ch1[j] = c;
    }

    boolean isEqual(char ch1[], char ch2[]) {
        return Arrays.equals(ch1, ch2);
    }
}

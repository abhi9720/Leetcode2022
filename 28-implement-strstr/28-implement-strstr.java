public class Solution {
    private static final int R = 31;
    private static final int Q = 997;

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int m = needle.length();
        int n = haystack.length();
        int mf = 1;
        for (int i = 1; i < m; i++) {
            mf = (mf * R) % Q;
        }
        int needleHash = hash(needle, 0, m);
        int hash = hash(haystack, 0, m);

        for (int i = m; i <= n; i++) {
            if (hash == needleHash && haystack.substring(i - m, i).equals(needle)) {
                return i - m;
            }
            if (i < n) {
                hash = (hash + Q - (mf * haystack.charAt(i - m) % Q)) % Q;
                hash = (hash * R + haystack.charAt(i)) % Q;
            }
        }
        return -1;
    }

    private static int hash(String s, int from, int to) {
        int hash = 0;
        for (int i = from; i < to; i++) {
            hash = ((hash * R) % Q + s.charAt(i)) % Q;
        }
        return hash;
    }
}

class Solution {

    public String longestPalindrome(String s) {
        // n^2
        int n = s.length();
        int start = 0, len = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = maxlenPalin(s, i, i);
            int len2 = maxlenPalin(s, i, i + 1);
            int l = Math.max(len1, len2);

            if (l > len) {
                start = i - (l - 1) / 2;
                end = i + l / 2;
                len = l;
            }
        }
        return s.substring(start, start + len);
    }

    private int maxlenPalin(String s, int i, int j) {
        int n = s.length();
        int len = 0;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            len += (i == j) ? 1 : 2;
            i -= 1;
            j += 1;
        }
        return len;
    }
}

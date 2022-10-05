class Solution {

    public String longestPrefix(String s) {
        int n = s.length();
        int table[] = new int[n];
        int i = 0, j = 1;
        while (j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                table[j] = i;
                j++;
            } else {
                if (i == 0) j++; else {
                    i = table[i - 1];
                }
            }
        }
        int len =  table[n-1];
        return s.substring(0,len);
    }
}

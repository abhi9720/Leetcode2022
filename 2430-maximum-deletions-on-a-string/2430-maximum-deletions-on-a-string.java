class Solution {

    public int deleteString(String s) {
        return lps(s);
    }

    int lps(String s) {
        
        int n = s.length();
        int table[] = new int[n];
        int i = 0, j = 1, max = 0;
        while (j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                table[j] = i + 1;
                i++;

                j++;
            } else {
                if (i != 0) {
                    i = table[i - 1];
                } else j++; // and i is already 0
            }
        }
        for (j = n - 1; j >= 0; j--) {
            if (j % 2 == 1) {
                if ((j / 2 + 1) == table[j]) {
                    return 1 + lps(s.substring(table[j]));
                }
            }
        }

        return 1;
    }
}

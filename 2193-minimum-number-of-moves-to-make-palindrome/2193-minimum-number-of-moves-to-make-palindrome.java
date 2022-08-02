class Solution {

    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1, count = 0;
        char ch[] = s.toCharArray();
        while (left < right) {
            int l = left, r = right;

            while (ch[l] != ch[r]) r--;

            if (l != r) {
                for (; r < right; r++) {
                    swap(ch, r, r+1);
                    count++;
                }
            } else {
                swap(ch, r, r + 1);
                count++;
                continue;
            }

            left++;
            right--;
        }
        return count;
    }

    private void swap(char ch[], int l, int r) {
        char c = ch[l];
        ch[l] = ch[r];
        ch[r] = c;
    }
}

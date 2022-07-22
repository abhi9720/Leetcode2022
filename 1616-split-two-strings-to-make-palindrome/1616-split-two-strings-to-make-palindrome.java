class Solution {

    boolean isPalindrome(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }
        return i >= j;
    }

    boolean check(String a, String b) {
        int i = 0, j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            ++i;
            --j;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }
}

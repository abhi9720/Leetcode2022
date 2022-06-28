class Solution {

    public int[] plusOne(int[] digits) {
        int c = 0, s = 0, n = digits.length;
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            s = digits[i] + c + (i == n - 1 ? 1 : 0);
            c = s / 10;
            s = s % 10;
            num.add(0, s);
        }
        if (c != 0) {
            num.add(0, c);
        }
        return num.stream().mapToInt(Integer::intValue).toArray();
    }
}

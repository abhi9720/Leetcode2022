class Solution {

    public int maximumSwap(int num) {
        char number[] = (num + "").toCharArray();
        int n = number.length;
        int largestToRight[] = new int[n];
        Arrays.fill(largestToRight, -1);
        char max = number[n - 1];
        int idx = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (number[i] > max) {
                max = number[i];
                idx = i;
            } else if (number[i] < max) {
                largestToRight[i] = idx;
            }
        }
        // System.out.println(Arrays.toString(number));
        // System.out.println(Arrays.toString(largestToRight));
        for (int i = 0; i < n; i++) {
            if (largestToRight[i] != -1) {
                int index = largestToRight[i];

                char ch = number[i];
                number[i] = number[index];
                number[index] = ch;
                break;
            }
        }
        // System.out.println(Arrays.toString(number));
        return Integer.parseInt(new String(number));
    }
}

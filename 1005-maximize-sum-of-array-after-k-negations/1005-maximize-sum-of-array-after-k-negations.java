class Solution {

    public int largestSumAfterKNegations(int[] A, int K) {
        int[] cnt = new int[201];
        int res = 0;
        for (int i : A) ++cnt[i + 100];
        for (int i = -100; i <= 100 && K > 0; ++i) {
            if (cnt[i + 100] > 0) {
                int k = i < 0 ? Math.min(K, cnt[i + 100]) : K % 2;
                cnt[-i + 100] += k;
                cnt[i + 100] -= k;
                K = i < 0 ? K - k : 0;
            }
        }
        for (int i = -100; i <= 100; ++i) res += i * cnt[i + 100];
        return res;
    }
}

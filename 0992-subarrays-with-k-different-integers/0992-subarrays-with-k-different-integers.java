class Solution {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    int atMostK(int[] A, int k) {
        int i = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            if (!map.containsKey(A[j])) k--;
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);

            while (k < 0) {
                int prev = map.put(A[i], map.get(A[i]) - 1);
                if (prev == 1) {
                    k++;
                    map.remove(A[i]);
                }
                i++;
            }
            res+= j-i+1;
        }
        return res;
    }
}

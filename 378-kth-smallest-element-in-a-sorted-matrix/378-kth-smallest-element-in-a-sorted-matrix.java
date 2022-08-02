class Solution {

    public int kthSmallest(int[][] arr, int k) {
        int n = arr.length;
        // element , rowIndex, eleIndex
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { arr[i][0], i, 0 });
        }
        while (true) {
            k -= 1;
            int peek[] = pq.remove();
            if (k == 0) return peek[0];
            int ridx = peek[1];
            int cidx = peek[2];
            if (cidx + 1 < n) {
                pq.offer(new int[] { arr[ridx][cidx + 1] , ridx,cidx+1 });
            }
        }
    }
}

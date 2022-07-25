class Solution {

    public boolean carPooling(int[][] trips, int cap) {
        Arrays.sort(trips, (o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int n = trips.length;
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[2] <= trips[i][1]) {
                cap += pq.peek()[0];
                pq.remove();
            }

            cap -= trips[i][0];
            pq.offer(trips[i]);
            if (cap < 0) {
                return false;
            }
        }
        return true;
    }
}

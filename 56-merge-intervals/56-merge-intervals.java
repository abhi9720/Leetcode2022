class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> li = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                li.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        li.add(new int[] { start, end });
        return li.toArray(new int[0][]);
    }
}

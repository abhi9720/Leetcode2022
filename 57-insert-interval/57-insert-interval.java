class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        boolean flag = true;
        while (i < intervals.length) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (s <= end && e >= start) {
                start = Math.min(start, s);
                end = Math.max(end, e);
            } else {
                if (flag && s > end) {
                    ans.add(new int[] { start, end });
                    flag = false;
                }

                ans.add(new int[] { s, e });
            }

            i++;
        }
        if (flag) {
            ans.add(new int[] { start, end });
        }

        return ans.toArray(new int[0][]);
    }
}

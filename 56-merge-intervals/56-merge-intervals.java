class Solution {

    public int[][] merge(int[][] intervals) {
        // Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // int start = intervals[0][0];
        // int end = intervals[0][1];
        // ArrayList<int[]> li = new ArrayList<>();
        // int i = 0, n = intervals.length;
        // while (i < n) {
        //     if (intervals[i][0] <= end) {
        //         end = Math.max(end, intervals[i][1]);
        //     } else {
        //         li.add(new int[] { start, end });
        //         start = intervals[i][0];
        //         end = intervals[i][1];
        //     }
        //     i++;
        // }
        // li.add(new int[] { start, end });
        // return li.toArray(new int[0][]);

        for (int interval[] : intervals) {
            add(interval[0], interval[1]);
        }
        int i = 0;
        int ans[][] = new int[map.size()][2];
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            ans[i++] = new int[] { it.getKey(), it.getValue() };
        }
        return ans;
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public void add(int left, int right) {
        if (map.floorKey(right) == null || map.get(map.floorKey(right)) < left) {
            map.put(left, right);
        } else {
            int start = left, end = right;
            while (true) {
                int l = map.floorKey(end);
                int r = map.get(l);
                start = Math.min(l, start);
                end = Math.max(r, end);

                map.remove(l);
                if (map.floorKey(end) == null || map.get(map.floorKey(end)) < start) {
                    break;
                }
            }

            map.put(start, end);
        }
    }
}

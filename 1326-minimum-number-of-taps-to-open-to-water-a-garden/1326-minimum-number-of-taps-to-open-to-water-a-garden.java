class Solution {

    public int minTaps(int n, int[] ranges) {
        //form intial list of intervals
        List<int[]> intervals = new ArrayList();
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int l = i - ranges[i], r = i + ranges[i];
            intervals.add(new int[] { l, r });
        }
        //sort intervals based on the left coordinate
        Comparator<int[]> comp = (a1, a2) -> a1[0] - a2[0];
        Collections.sort(intervals, comp);

        //checking how exactly we can merge intervals
        int l = 0, r = 0, res = 0, i = 0;
        while (l < n && i <= intervals.size()) {
            //getting the interval which ends the fatherst to the right
            while (i < intervals.size() && intervals.get(i)[0] <= l) {
                r = Math.max(r, intervals.get(i)[1]);
                ++i;
            }
            //if we can't find the right position that extends our current section - it means that there is a
            //gap and some interval of the pitch is not covered. Thus solution is not posible
            if (l >= r) return -1;
            //if we reach here means we found section that covers next piece of the pitch, so
            //make our right coordiate as a left for next searches, also increment count of solutions - we
            //picked just one from the list of intervals
            ++res;
            l = r;
        }
        return res;
    }
}

class Solution {

    public int findPoisonedDuration(int[] timeSeries, int d) {
        int start = -1, end = -1;
        int time = 0;
        for (int t : timeSeries) {
            int s = t, e = t + d - 1;
            if (s <= end) {
                time += (d - (end - s + 1));
            } else {
                time += d;
            }
            start  =  s;
            end =  e;
        }
        return time;
    }
}

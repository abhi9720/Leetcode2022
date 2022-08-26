class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int jobs[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        // Arrays.sort(
        //     job,
        //     (a, b) -> {
        //         if (a[0] == b[0]) return a[1] - b[1]; else return a[0] - b[0];
        //     }
        // );

        // O(n^2) Approach
        // int lis[] = new int[n];
        // int maxProfit = 0;
        // for (int i = 0; i < n; i++) {
        //     int max = 0;
        //     for (int j = 0; j < i; j++) {
        //         if (job[i][0] >= job[j][1]) {
        //             max = Math.max(max, lis[j]);
        //         }
        //     }
        //     lis[i] = max + job[i][2];
        //     maxProfit = Math.max(maxProfit, lis[i]);
        // }
        // return maxProfit;

        
        
        // O(nlogn) Approach
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        // maintaining tail in sorted order 
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            // end time <= start time 
            int cur = dp.get( dp.floorKey(job[0]) ) + job[2];
            if (cur > dp.lastEntry().getValue()) dp.put(job[1], cur);
        }
        return dp.lastEntry().getValue();
    }
}

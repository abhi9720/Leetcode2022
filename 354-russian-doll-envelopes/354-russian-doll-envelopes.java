class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        // two things are changining
        // for envelop to fit in another envelop -
        // x and y coordinate should be greater than than other envelop ti fit it completely
        Arrays.sort(
            envelopes,
            (o1, o2) -> {
                if (o2[0] == o1[0]) {
                    //  to handle case of [4,5] , [4,6] 
                    // [4,6] cannnot accomodate [4,5]
                    // we keep [4,6] before [4,5] 
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        );

        int n = envelopes.length;
        int tail[] = new int[n];
        int size = 0;
        for (int env[] : envelopes) {
            int lo = 0, hi = size;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (tail[mid] < env[1]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            tail[lo] = env[1];
            if (lo == size) {
                size += 1;
            }
        }

        return size;
    }
}

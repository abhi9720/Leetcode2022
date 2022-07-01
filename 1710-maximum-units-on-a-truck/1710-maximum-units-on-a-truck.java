class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxLoad = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int box[] : boxTypes) {
            int numi = box[0], perunit = box[1];
            if (numi > truckSize) {
                maxLoad += (truckSize) * perunit;
            } else {
                maxLoad += (numi) * perunit;
            }
            truckSize -= numi;
            if (truckSize <= 0) break;
        }

        return maxLoad;
    }
}

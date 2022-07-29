class Solution {

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        int start = points[0][0];
        int end = points[0][1];

        int i = 0;
        int count = 1;
        while (i < n) {
            if (points[i][0] <= end) {
                end =  Math.min(end , points[i][1]);
            } else {
                count++;
                start = points[i][0];
                end = points[i][1];
            }
            i++;
        }
        return count;
    }
}

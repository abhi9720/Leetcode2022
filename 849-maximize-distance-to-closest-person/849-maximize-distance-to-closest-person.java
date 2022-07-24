class Solution {

    public int maxDistToClosest(int[] seats) {
        int prev = -1, maxDist = 0;
        int n = seats.length;
        for (int i = 0; i < n; i++) {
            if(seats[i]==1){
                maxDist  =  prev<0?i:  Math.max(maxDist , (i-prev)/2);
                prev =  i;
            }
        }
        maxDist =  Math.max(maxDist , (n-1 - prev ));
        return maxDist;
    }
}

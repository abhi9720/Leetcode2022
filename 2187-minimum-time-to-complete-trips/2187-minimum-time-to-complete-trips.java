class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1, r = (long)1e14;
        
        while(l<r){
            long mid = (l + (r-l)/2);
            long total = 0;
            for(int i=0;i<time.length;i++){
                total += mid/time[i];
            }
            if(total>=totalTrips){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        
        return l;
    }
}
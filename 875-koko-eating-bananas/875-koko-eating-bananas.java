class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     
        Arrays.sort(piles);
        int n  =  piles.length;
        int lo =  1 ,  hi =  piles[n-1];
        
        while(lo<=hi){
            int mid =  (hi-lo)/2+lo;
            int time =  timeAtThisSpeed(mid  ,  piles);
            
            if(time <= h){                
                hi = mid -1;
            }
            else{
                lo  =  mid+1;
            }            
        }
        return lo;        
    }
    private int timeAtThisSpeed(int s , int piles[]){
        int time  = 0;
        for(int ele : piles){
            time+= Math.ceil(ele*1.0 / s);
        }
        return time;
    }
}
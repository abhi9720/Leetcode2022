class Solution {
    public int maxDistToClosest(int[] seats) {
        int n  =  seats.length;
        int left[] =  new int[n];
        int right[] =  new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        
        int lidx =  -1;
        for(int i=0;i<n;i++){
            if(seats[i]==1 ){
                lidx =  i;
            }
            left[i] =  lidx;
        }
        int ridx =  -1;
        for(int i=n-1;i>=0;i--){
            if(seats[i]==1 ){
                ridx = i;
            }
            right[i] =  ridx;
        }
        
        int Maxdist =  0;
        for(int i=0;i<n;i++){
            int l,r;
            l=r = Integer.MAX_VALUE;
            if(left[i]!=-1){
                l =  i - left[i]  ;
            }
            if(right[i]!=-1){
                r =  right[i] - i;
            }
            
            int dist =  Math.min(l,r);
            Maxdist =  Math.max(Maxdist,dist);            
        }
        return Maxdist;                        
    }
}
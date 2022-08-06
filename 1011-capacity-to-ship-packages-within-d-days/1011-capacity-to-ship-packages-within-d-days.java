class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l =  weights[0] ,  h =  0;
        for(int ele: weights){
            l =  Math.max(ele , l);
            h+= ele;
        }
        
        while(l<h){
            int mid =  (h-l)/2+l;
            
            int d = 1, sum = 0;
            for(int ele : weights){
                if(sum+ele<=mid){
                    sum+=ele;
                }
                else{
                    d+=1;
                    sum =  ele;
                }
            }
            
            if( d <= days  ){
                h =  mid;
            }
            else{
                l =  mid+1;
            }                        
        }
        return l;
        
    }
}
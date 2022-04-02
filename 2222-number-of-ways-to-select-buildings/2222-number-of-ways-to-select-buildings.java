class Solution {
    public long numberOfWays(String s) {
        long count0 = 0 , count1 = 0;
        int n  =  s.length();
        long left[] =  new long[n];
        long right[] =  new long[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1' ){
                count1++;
                left[i] =  count0;
            }
            if(s.charAt(i)=='0' ){
                count0++;
                left[i] =  count1;
            }            
        }
        
        count1 = 0;
        count0 = 0;
        for(int i =  n-1 ;i>=0;i--){
            if(s.charAt(i)=='1' ){
                count1++;
                right[i] =  count0;
            }
            if(s.charAt(i)=='0' ){
                count0++;
                right[i] =  count1;
            }                        
        }
        
        long ways = 0;
        for(int i=0;i<n;i++){
            char chi = s.charAt(i);
            ways +=  left[i]*right[i];
        }

        return ways;
        
    }
}
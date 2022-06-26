class Solution {
    public int maxScore(int[] p, int k) {
        int n  =  p.length;
        k =  n -  k;
        int ws= 0 , sum = 0;
        for(int i=0;i<n;i++){
            if(i<k) ws+=p[i];
            sum+=p[i];
        }
        int max =  sum - ws;
        for(int i=k;i<n;i++){
            ws =  ws - p[i-k] + p[i];
            max =  Math.max( max , sum -ws );
        }
        
        return max;
        
        
    }
}
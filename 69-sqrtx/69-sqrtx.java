class Solution {
    public int mySqrt(int x) {
        // binary search
        if(x<=1) return x;
        
        double  i = 0, j =  x/2;
        while(j-i >= 1e-5){
            double mid =  (j-i)/2+i;
            if(mid*mid > x ){
                j =  mid;
            }
            else{
                i =  mid;
            }
            
        }
        
        return (int)j;
    }
}
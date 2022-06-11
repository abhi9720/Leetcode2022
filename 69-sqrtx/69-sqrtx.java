class Solution {
    public int mySqrt(int x) {
        // binary search
        
        double  i = 1, j =  x;
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
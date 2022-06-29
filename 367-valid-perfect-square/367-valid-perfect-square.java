class Solution {
    public boolean isPerfectSquare(int num) {
        double i = 1 , j =  2147483647;
        while(j-i >= 1e-1){
            double mid =  (j-i)/2+i;
            if(mid < num/mid ){
                i =  mid+1;
            }
            else if( mid > num/mid ){
                j  = mid-1;
            }
            else{
                return true;
            }            
        }
        
        return i*j==num;
    }
}
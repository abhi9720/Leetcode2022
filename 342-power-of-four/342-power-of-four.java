class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;        
        
        if((n&-n)==n){// number should be also power of 2, rsb  same as number 
            // count  0 
            int c=0;
            while(n!=1){
                n>>>=1;
                c++;                    
            }
            return ((c&1)==0);
        }
        else{
            return false;
        }
    }
}
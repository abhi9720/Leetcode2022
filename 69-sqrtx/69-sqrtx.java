class Solution {
    public int mySqrt(int x) {
        // binary search
        if(x<=1) return x;
        
        int  i = 0, j =  x;
        while(i<j){
            int mid =  (j-i)/2+i;
            if(mid > x/mid ){
                j =  mid;
            }
            else{
                // mid <= x / mid && (mid + 1) > x / (mid + 1
                if ( (mid + 1) > x / (mid + 1))// Found the result
			        return mid; 
                i =  mid+1;
            }            
        }
        
        return (int)j;
    }
}
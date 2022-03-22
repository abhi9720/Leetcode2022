class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb =  new StringBuilder();
        while(n>0){
            // generate option one 
            int newN =  n-1;
            int newK =  k-1;
            if( newK < 26*newN ){
                sb.append("a");
                n =  newN;
                k =  k-1;
            }
            else{
                int idx =  ( k -  26*newN  );
                char ch =  (char)( 96 + idx  );
                sb.append(ch);
                n = newN;
                k =  k -  idx;
            }
        }
        return sb.toString();
    }
}

// we have array 1 to 26 , we have to find subarray sum equal to k 
// and an element can be used any number of times .  
// of length n 
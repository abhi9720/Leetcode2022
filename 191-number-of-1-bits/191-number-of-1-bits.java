public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bit = 0;
        while(n!=0){
            int lsb =  n&(-n);
            n =  n-lsb;
            bit++;
        }    
        return bit;
    }
}
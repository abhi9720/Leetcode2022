class Solution {

    public int[] plusOne(int[] digits) {
        int c = 0, s = 0, n = digits.length;
        
        for (int i = n - 1; i >= 0; i--) {
            s = digits[i] + c + (i == n - 1 ? 1 : 0);            
            c = s / 10;
            s = s % 10;
            digits[i] =  s;
            if(digits[i]!=0) break;
        }
        if (c != 0) {
            int temp[] =  digits;
            digits=  new int[n+1];
            digits[0] =  1;            
        }
        
        return digits;
    }
}

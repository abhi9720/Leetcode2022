class Solution {

    public int myAtoi(String s) {        
        int i = 0, n = s.length();
        // skip spaces 
        while (i < n && s.charAt(i) == 32) i++;
        
        int num = 0;
        boolean negative = false;
        
        // handle sign 
        if (i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                negative ^= true;
            }
            i += 1;
        }
        
        
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int prev = num;
            num = num * 10 + (s.charAt(i) - '0');
            if( prev!=num/10){// to handle overflow happend or not 
                num =  negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
                return num;
            }
            i++;
        }
        return negative ? -num : num;
    }
}

class Solution {

    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == 32) i++;
        int num = 0;
        boolean sign = false;
        if (i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign ^= true;
            }
            i += 1;
        }
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int prev = num;
            num = num * 10 + (s.charAt(i) - '0');
            if( prev!=num/10){
                num =  sign?Integer.MIN_VALUE:Integer.MAX_VALUE;
                return num;
            }
            i++;
        }
        return sign ? -num : num;
    }
}

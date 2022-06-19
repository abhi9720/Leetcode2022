class Solution {

    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int j = n - 1;
        int len = 0;
        int val = 0 , pw =  1;
        len = (int) s.chars().filter(ch -> ch == '0').count();
        while (j >= 0 && val + pw <= k) {
            if (s.charAt(j) == '0') {
                len-=1;
            } else{
                val += pw;                
            }
            
            len+=1;
            pw = pw * 2;
            j -= 1;
        }

        return len;
    }
}

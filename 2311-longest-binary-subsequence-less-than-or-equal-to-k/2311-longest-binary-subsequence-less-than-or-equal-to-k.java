class Solution {

    public int longestSubsequence(String s, int k) {
        int n  =  s.length();
        int val = 0, cnt = 0, pow = 1;
        cnt = (int)s.chars().filter(ch -> ch == '0').count();
        for(int i=n-1;i>=0 && val +pow <=k ;i-- ){
            if(s.charAt(i)=='1' ){
                val+=pow;                
            }
            else{
                cnt--;
            }
            cnt++;
            pow = pow*2 ;
        }
        return cnt;

        
    }
}

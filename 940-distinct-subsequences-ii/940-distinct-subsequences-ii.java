class Solution {
    public int distinctSubseqII(String s) {
        final  int MOD =  1_000_000_007;
        int  n =  s.length();
        int lastOcurr[] =  new int[26];
        Arrays.fill(lastOcurr,-1);
        int dp[] =  new int[n+1];
        dp[0]= 1;// count of empty string
        for(int i=0;i<n;i++){
            int idx =  s.charAt(i) -'a';
            dp[i+1] =  (2*dp[i]) % MOD;
            if(lastOcurr[idx]>=0){
                dp[i+1] -=  dp[lastOcurr[idx]];
            }
            dp[i+1]%= MOD;
            lastOcurr[idx] =  i;            
        }
        // remove count of empty string 
        dp[n]-=1;
        if (dp[n] < 0) dp[n] += MOD;
        return dp[n];
    }
   
}
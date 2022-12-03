class Solution {
    public String longestPalindrome(String s) {
        int n  =  s.length();
        int dp[][] =  new int[n][n];
        int maxlen = 0;
        int si  = 0;
        for(int gap=0;gap<n;gap++){
            for(int i=0;i<n-gap;i++){
                int j =  i+gap;
                if(gap==0){
                    dp[i][j] =  1;
                }
                else if(gap==1){
                    dp[i][j] =  s.charAt(i)==s.charAt(j)?2:0;
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0){
                        dp[i][j] =  2+dp[i+1][j-1];
                    }
                    else{
                        dp[i][j] = 0;
                    }
                }
                if(dp[i][j]>maxlen){
                    maxlen =  dp[i][j];
                    si =  i;                    
                }
            }
        }
        
         
        return s.substring(si,si+maxlen ) ;
            
        
    }
}
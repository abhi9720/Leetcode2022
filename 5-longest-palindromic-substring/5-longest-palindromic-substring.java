class Solution {
    public String longestPalindrome(String s) {
        int n  =  s.length();
        boolean dp[][] =  new boolean[n][n];
        int st = 0 ,len = 0;
        for(int gap=0;gap<n;gap++){
            for(int i=0,j =  gap; i+gap<n; i++ , j++  ){
                if(gap==0){
                    dp[i][j] =  true;
                }
                else if(gap==1){
                    dp[i][j] =  s.charAt(i) == s.charAt(j);
                }
                else{
                    dp[i][j] =  dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }       
                if(dp[i][j] && (j-i+1) > len){
                    len  =  j-i+1;
                    st  = i;
                }
            }
        }
        return s.substring(st,st+len);                
    }
}
class Solution {
    public String longestPalindrome(String s) {
        
 //Approch 1        
//         int n =  s.length();
//         boolean dp[][] = new boolean[n][n];
//         String ans = "";
//         for(int gap=0;gap<n;gap++){            
//             for(int i=0, j=gap ; j<n ; i++,j++){
//                 if(gap==0) dp[i][j] = true;
//                 else if(gap==1) dp[i][j] =  s.charAt(i)==s.charAt(j);
//                 else{                    
//                     dp[i][j] =  dp[i+1][j-1]  && ( s.charAt(i)==s.charAt(j));                                                        }                
//                 if(gap+1 > ans.length() && dp[i][j] ){
//                     ans  = s.substring(i,j+1);
//                 }
//             }            
//         }
//         return ans;
        
        // Approch 2
        
        // taking each center as palindrome center and explore about each center 
        
        if(s==null || s.length() ==0) return "";
        int n =  s.length();
        int start = 0, end=0;
        for(int i=0;i<n;i++){
            int len1 = expandCenter(s,i,i);
            int len2 = expandCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>end-start){
                start =  i-(len-1) / 2; //  -1 beacuse of even length , they have len/2-1 element on left 
                end =  i+(len)/2; // they have len/2 element on rigt 
            }            
        }
        return s.substring(start,end+1);                        
    }
    
    private int expandCenter(String s , int l , int r){
        
        while(l>=0 && r<s.length()  && s.charAt(l)==s.charAt(r)){
            l--;r++;
        }
        return r-l-1;
        
    }
}
class Solution {
    public int countSubstrings(String s) {
       // return dp_code(s);
        return countPalin(s);
    }
    public int dp_code(String s){
         int l =  s.length();
        boolean dp[][] =  new boolean[l][l];
        int count  = 0;
        for(int gap=0;gap<l;gap++){
            for(int i=0 ; i<l-gap;i++){
                int j =  i+gap;
                if(gap==0 ){
                    
                    dp[i][j] =  true;
                }
                else if( gap==1){                     
                    dp[i][j] =( s.charAt(i) == s.charAt(j));  
                }
                else{
                    // we check i+1 to j-1 string  is palin or not
                    if(s.charAt(i) == s.charAt(j))
                       { 
                        dp[i][j] =  (true) && (dp[i+1][j-1]);}
                    else
                          dp[i][j] =  false;
                        
                }
                if(dp[i][j]){
                    count++;
                }
                
                
            }
            
        }
        
        
        return count;
    }

    public int countPalin(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        int count  =0;
        for(int i=0;i<s.length();i++){
            count+=  extend(s,i,i);
            count+=  extend(s,i,i+1);
        }
        return count;
    }
    public int extend(String s , int  i , int j){
        int count  =0;
        while((i>=0 && j<s.length()) && (s.charAt(i)==s.charAt(j))){
            i--;
            j++;
            count++;
        }
    return count;
    }

}
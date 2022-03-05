class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int dp[] =  new int[(int)10e4+1];
        for(int ele : nums){
            dp[ele]+=ele;
        }
        
        // now this quesiton is almost similar to robber house question 
        // if we pick ith index element that means i-1 will Consequently  deleted
        // means if we rob ith house then i-1 house will be skipped
        // agar mai 2 ko le raha hu to 1 ko nahii liya houga , uski value skip 
        // variable 
        // take and skip variable mai , i-1 index ko include ya na include karne 
        // ki value hoti hai respectively .
        int take  = 0;
        int skip  = 0;
        
        for(int i=0;i<(int)10e4+1;i++){
            // here we have two choice either pick this element or not pick
            int newtake =  dp[ i ]+skip;
            int newskip =  Math.max(skip,take);
            take =  newtake;
            skip =  newskip;
        }
        return Math.max(take,skip);
          
    }
}
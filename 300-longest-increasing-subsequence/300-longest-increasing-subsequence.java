class Solution {
    public int lengthOfLIS(int[] nums) {
        // we can maintain our tail as miniumum possible so any higher element can append;
        // instead of doing linear back traversal 
        // we can do binary search 
        
        int tail[] =  new int[nums.length];
        int maxLen=  0;// current maxlen  or size 
        for(int x : nums){
            int  i =0 , j = maxLen;
            while(i!=j){
                int m =  i+(j-i)/2;
                if(tail[m]<x){
                    i =  m+1;
                }else{
                    j =  m;
                }
            }
            // if this elment is smaller than tail element then it will be updating tail
            tail[i] = x;
            // means if i== maxlen , means this new element is bigger than all elment 
            // ans will append at the end  tail , so size will increase 
            if(i==maxLen) ++maxLen;            
        }
        return maxLen;
        
        
    }
}
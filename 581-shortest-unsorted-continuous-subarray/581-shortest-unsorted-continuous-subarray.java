class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        
        // cases of failure 
        // either less than the max till now 
        // prev > curr
        int start =  -1,end =  -1;
        int max =  nums[0];
        for(int i=1;i<nums.length;i++ ){
                              
            
            
            if(nums[i] < max){
                if(start==-1){
                    start  = i-1;                    
                }
                while(start-1>=0 && nums[start-1]>nums[i]){

                    start--;
                }
                end =  i+1;
                
            }            
            max  =  Math.max(nums[i],max);
        }
        return end-start;
        
    }
}
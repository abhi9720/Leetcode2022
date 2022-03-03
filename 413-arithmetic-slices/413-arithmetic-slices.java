class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int curr = 0, seq = 0;
        for(int i=2;i<nums.length;i++){
            
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                curr++;
                seq+=curr;
                
            }
            else{
                curr=0;
            }
            
            
        }
        return seq;
        
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] <=0 ) nums[i]  = nums.length+1;            
        }
        for(int i=0;i<nums.length;i++){
            int idx =  nums[i]-1;
            while( idx<nums.length && nums[idx]-1 != idx){
                int t =  nums[idx];
                nums[idx] =  nums[i];
                nums[i] =  t;
                idx =  nums[i]-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1!=i) return i+1;
        }
        return nums.length+1;
    }
}
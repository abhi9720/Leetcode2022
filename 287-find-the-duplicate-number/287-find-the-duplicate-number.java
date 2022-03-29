class Solution {
    public int findDuplicate(int[] nums) {
        for(int ele : nums){
            int idx =  Math.abs(ele)-1;
            if(nums[idx]<0){
                return idx+1;
            }else{
                nums[idx] = -1*nums[idx];
            }
        }
        return -1;
    }
}
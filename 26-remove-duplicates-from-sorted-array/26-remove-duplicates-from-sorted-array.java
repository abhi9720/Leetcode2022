class Solution {
    public int removeDuplicates(int[] nums) {
        int itr = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1] ){
                nums[itr++] =  nums[i];
            }
        }
        return itr;
    }
}
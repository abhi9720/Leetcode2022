class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int arr[] =  new int[nums.length];
        int idx1 = 0, idx2 = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0 ){
                arr[idx1++] =  nums[i];
            }
            else{
                arr[idx2--] =  nums[i];
            }
        }
        return arr;
    }
}
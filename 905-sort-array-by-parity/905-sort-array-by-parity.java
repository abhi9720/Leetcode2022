class Solution {

    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        while (j < n) {
            if ((nums[j] & 1) == 0) {
                swap(nums , i , j);
                i++;
            }
            j++;
        }
        return nums;
    }

    private void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

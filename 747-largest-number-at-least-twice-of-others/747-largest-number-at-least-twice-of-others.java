class Solution {

    public int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if (ele > max1) {
                max2 = max1;
                max1 = ele;
                idx = i;
            } else if (ele > max2) {
                max2 = ele;
            }
        }
        if (max1 / 2 >= max2) {
            return idx;
        }
        return -1;
    }
}

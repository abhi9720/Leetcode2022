class Solution {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int c = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int prev = 0;
        int i = 0;
        for (int ele : nums) {
            max = Math.max(max, ele);

            if ( max <= right) {
                c++;
                count += (ele < left) ? prev : c;
                prev = ele < left ? prev : c;
            } else {
                c = 0;
                prev = 0;
                max = Integer.MIN_VALUE;
            }
        }
        return count;
    }
}

class Solution {

    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1, hi = 0;
        for (int ele : nums) {
            hi = Math.max(ele, hi);
        }
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            int op = 0;
            for (int ele : nums) {
                if (ele > mid) {
                    // op+= (Math.ceil( (ele*1.0) / mid  ) -  1);
                    op += (ele / mid) + -(ele % mid == 0 ? 1 : 0);
                }
            }
            if (op > maxOperations) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

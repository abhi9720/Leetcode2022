class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        // kth index pair is that , on its left including it all pair 
        // have diff <= k
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        
        return lo;
    }
}
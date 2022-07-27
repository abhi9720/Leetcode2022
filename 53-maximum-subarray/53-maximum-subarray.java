class Solution {

    public int maxSubArray(int[] nums) {
        // total sum from starting point to current index become
        // negative , it make no sense to continue to same subarray
        // discard that array , and start new subarray

        int sum = 0, n = nums.length, maxSum = nums[0];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) sum = 0; 
            // there no sense to continue 
            // negative subarray , discard it and start new subarray from 
            // next index 
            
        }
        return maxSum;
    }
}

class Solution {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
		int sum = 0;
        for(int ele : nums){
			sum+=ele;
			maxSum =  Math.max(maxSum,sum);
			sum = Math.max(sum,0);			
		}
		return maxSum;
    }
}
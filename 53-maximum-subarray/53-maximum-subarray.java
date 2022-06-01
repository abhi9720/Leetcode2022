class Solution {

    public static int maxSubArray(int[] nums) {
        int storage[] = new int[nums.length];
        int max = nums[0];
        storage[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            storage[i] = Math.max(storage[i - 1] + nums[i], nums[i]);
            if (storage[i] > max) {
                max = storage[i];
            }
        }

        return max;
    }
}

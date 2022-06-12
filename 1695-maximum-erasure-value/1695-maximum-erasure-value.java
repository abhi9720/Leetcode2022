class Solution {

    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        //        ele     index
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxSum = 0;
        while (j < nums.length) {
            while (map.containsKey(nums[j])) {
                sum -= nums[i];
                map.remove(nums[i]);
                i++;
            }

            map.put(nums[j], j);
            sum += nums[j];
            maxSum = Math.max(maxSum, sum);
            j++;
        }

        return maxSum;
    }
}

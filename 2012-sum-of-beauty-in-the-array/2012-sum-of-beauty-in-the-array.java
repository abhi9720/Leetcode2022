class Solution {

    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int leftMax[] = new int[n], rightMin[] = new int[n];
        rightMin[n-1] =  Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i + 1]);
        }
        

        int sob = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMax[i] && nums[i] < rightMin[i]) {
                sob += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                sob += 1;
            }
        }
        return sob;
    }
}

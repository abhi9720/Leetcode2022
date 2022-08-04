class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }            
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    private void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

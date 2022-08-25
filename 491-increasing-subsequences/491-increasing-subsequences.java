class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        ArrayList<Integer> seq = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        helper(nums, ans, seq, 0, Integer.MIN_VALUE);
        List<List<Integer>> fans = new ArrayList<>(ans);
        return fans;
    }

    private void helper(int nums[], Set<List<Integer>> ans, ArrayList<Integer> seq, int idx, int next) {
        if (idx == nums.length) {
            if (seq.size() > 1) ans.add(new ArrayList<>(seq));
            return;
        }

        // pick or not pick

        helper(nums, ans, seq, idx + 1, next);

        if (nums[idx] >= next) {
            seq.add(nums[idx]);
            helper(nums, ans, seq, idx + 1, nums[idx]);
            seq.remove(seq.size() - 1);
        }
    }
}

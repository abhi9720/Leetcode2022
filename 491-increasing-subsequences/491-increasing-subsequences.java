class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        LinkedList<Integer> seq = new LinkedList<>();
        Set<List<Integer>> ans = new HashSet<>();
        helper(nums, ans, seq, 0, Integer.MIN_VALUE);
        List<List<Integer>> fans = new LinkedList<>(ans);
        return fans;
    }

    private void helper(int nums[], Set<List<Integer>> ans,LinkedList<Integer> seq, int idx, int next) {
        if (idx == nums.length) {
            if (seq.size() > 1) ans.add(new ArrayList<>(seq));
            return;
        }

        // pick or not pick

        helper(nums, ans, seq, idx + 1, next);

        if (nums[idx] >= next) {
            seq.add(nums[idx]);
            helper(nums, ans, seq, idx + 1, nums[idx]);
            seq.removeLast();
        }
    }
}

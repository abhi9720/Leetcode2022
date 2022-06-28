class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            

            Integer preidx = map.put(nums[i], i);
            if (preidx!=null && i - preidx <= k) return true;
        }
        return false;
    }
}

class FindSumPairs {
    ArrayList<Integer> store = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    int nums1[];

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;

        for (int ele : nums2) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            store.add(ele);
        }
    }

    public void add(int index, int val) {
        int ele = val;

        // update hashmap
        int prev = store.get(index);

        map.put(prev, map.get(prev) - 1);

        ele += store.get(index);
        store.set(index, ele);

        map.put(ele, map.getOrDefault(ele, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int ele : nums1) {
            if (map.containsKey(tot - ele)) {
                count += map.get(tot - ele);
            }
        }
        return count;
    }
}
/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */

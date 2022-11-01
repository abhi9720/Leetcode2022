class Solution {

    public int countPairs(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if (map.containsKey(ele)) {
                List<Integer> li = map.get(ele);
                for (int index : li) {
                    if (index * i % k == 0) {
                        count++;
                    }
                }
            } else {
                map.put(ele, new ArrayList<Integer>());
            }
            map.get(ele).add(i);
        }
        return count;
    }
}

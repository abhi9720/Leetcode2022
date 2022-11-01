class Solution {

    public int longestConsecutive(int[] nums) {
        int maxlen = 0, len = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int ele:nums) set.add(ele);
        for (int i = 0; i < nums.length; i++) {            
            int k1 = nums[i] - 1, k2 =  nums[i]+1;
            while (set.contains(k1)) set.remove(k1--);            
            while (set.contains(k2)) set.remove(k2++);                
            len =  k2 - k1-1;
            maxlen =  Math.max(maxlen , len);
        }
        return maxlen;
    }
}

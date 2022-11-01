class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set =  new HashSet<>();
        for(int ele : nums){
            if(!set.add(ele)) return true;
        }
        return false;
    }
}


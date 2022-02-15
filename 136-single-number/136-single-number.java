class Solution {
    public int singleNumber(int[] nums) {
        int single =  0;
        for(int ele : nums){
            single =  single^ele;
        }
        return single;
    }
}
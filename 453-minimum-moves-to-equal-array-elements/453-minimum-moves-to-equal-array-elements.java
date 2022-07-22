class Solution {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0 , n =  nums.length;
        for (int ele : nums) {
            min = Math.min(min, ele);
            sum += ele;
        }
        
        return sum  - n*min;
    }
}

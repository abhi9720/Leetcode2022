class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i =0, j =  nums.length-1;
        int move = 0;
        while(i<=j){
            move+=( nums[j] - nums[i] );
            i++;
            j--;                
        }
        return move;        
    }
}
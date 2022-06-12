class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> unique =  new HashSet<>();
        int i = 0, j =  0, maxscore = 0;
        int sum = 0;
        while(j<nums.length){
            while(unique.contains( nums[j] ) ){
                sum-=nums[i];
                unique.remove(nums[i++] );
            }
            sum+=nums[j];
            unique.add(nums[j++] );
            maxscore =  Math.max(maxscore,sum);
        }
        return maxscore;
    }
}
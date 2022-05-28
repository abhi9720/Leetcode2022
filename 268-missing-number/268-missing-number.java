class Solution {
    public int missingNumber(int[] nums) {
        int sum =  0;
        for(int ele : nums){
            sum+=ele;
        }
        int n =  nums.length;
        int s =  n*(n+1)/2;
        return  s - sum;
        
    }
}
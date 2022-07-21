class Solution {
    public int maximumProduct(int[] nums) {
        int n =  nums.length;
        Arrays.sort(nums);
        
        int v1 =  nums[0] * nums[1] * nums[2];
        int v2 =  nums[n-1]*nums[n-2]*nums[n-3];
        int v3 =  nums[n-1]*nums[0]*nums[1];
        
        return Math.max(v1,Math.max(v2,v3));
        
        
        
    }
}
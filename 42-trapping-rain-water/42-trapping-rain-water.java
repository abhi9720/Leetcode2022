class Solution {
    public int trap(int[] nums) {
        int n  =  nums.length;
        int leftmax[] =  new int[n];
        int rightmax[] =  new int[n];
        int lmax = nums[0];
        for(int i=0;i<n;i++){
            if(nums[i] < lmax ){
                leftmax[i] = lmax;
            }
            lmax =  Math.max(nums[i] , lmax );
        }
        int rmax =  nums[n-1];
        for(int i=n-1;i>=0;i-- ){
            if(nums[i] < rmax ){
                rightmax[i] =  rmax;
            }
            rmax  = Math.max(rmax,nums[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans+=  Math.max( Math.min(leftmax[i],rightmax[i]) - nums[i] ,0 );;
        }
        return ans;
        
    }
}
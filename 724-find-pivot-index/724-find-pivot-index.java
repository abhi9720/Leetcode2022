class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int ele : nums){
            sum+=ele;
        }   
        int l = 0, r = sum-nums[0];
        if(l==r) return 0;
        for(int i=0;i<nums.length;i++){
            if(l==r) return i;            
            l+=nums[i];
            if(i+1<nums.length) r-=nums[i+1];
        }        
        return -1;
    }
}
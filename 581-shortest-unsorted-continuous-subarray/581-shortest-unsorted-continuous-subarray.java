class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l=0,r =  nums.length-1;
        int max  =  Integer.MIN_VALUE, min =  Integer.MAX_VALUE;
        int st =  0, nd = -1;
        while(r>=0){
            if(nums[l] >= max) max =  nums[l]; else nd  = l;
            if(nums[r] <= min) min =  nums[r]; else st =  r;
            l+=1;
            r-=1;
        }
        return nd-st+1;
        
    }
}
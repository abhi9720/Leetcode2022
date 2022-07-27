class Solution {

    public int maxProduct(int[] nums) {
        int p1 = 1, p2 = 1;
        // either maxprodouct come from prefix or suffix 
        // 0 found start from next index 
        int n  = nums.length;
        int lo =  0 , hi =  n-1;
        int max =  nums[0];
        while(lo<n && hi>=0){
            p1 =  nums[lo]*p1;
            p2 =  nums[hi]*p2;
            max =  Math.max(max , Math.max(p1 , p2));
            // 0 break our prefix and suffix , so start new from next index 
            if(nums[lo]==0 ) p1 =  1;
            if(nums[hi]==0) p2 =  1;
            lo++;
            hi-=1;
        }
        return max;
        
    }
}

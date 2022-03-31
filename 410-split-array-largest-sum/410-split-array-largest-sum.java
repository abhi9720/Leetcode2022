class Solution {
    public int splitArray(int[] nums, int m) {
        int sum  =  0, max = 0;
        for(int ele : nums){
            sum+=ele;
            max = Math.max(max,ele);
        }
        int low =  max;
        int high =  sum+1;
        while(low<=high){
            int mid =  low + (high-low)/2;
            boolean ans =  canSplit(nums,mid,m);
            if(ans == false ) low =  mid+1;
            else high =  mid-1;            
        }
     
        return  low;
        
    }
    private boolean canSplit(int []nums , int limit, int m){
        int split = 0;
        int currentSum =0;
        for(int i=0;i<nums.length;i++){
            if(currentSum+nums[i]<=limit){
                currentSum+=nums[i];
            }else{
                currentSum =  nums[i];
                split++;
            }            
        }
        return (split+1)<=m;
    }
        
    
}
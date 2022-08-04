class Solution {
    public int findMin(int[] nums) {
        
        
        // first find the roated point
        int n =  nums.length;
        int l =  0 , h = n-1;
        while(l<h){
            int mid =  (l+h)/2;
            if(nums[h] > nums[mid] ) h =  mid;
            else l =  mid+1;
        }
        
        return nums[l];
    }
}
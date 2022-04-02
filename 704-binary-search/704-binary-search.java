class Solution {
    public int search(int[] nums, int target) {
     
        int i =  0 , j =  nums.length-1;
        while(i<j){
            
            int mid =  i+(j-i+1)/2;// take uppper mid , we are making decision on right boundary
            if( nums[mid] > target ){
                j =  mid-1;
            }else{
                i = mid;
            }
        }
        return nums[i]==target?i:-1;
    }
}
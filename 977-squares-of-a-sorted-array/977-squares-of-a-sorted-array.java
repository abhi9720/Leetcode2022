class Solution {
    public int[] sortedSquares(int[] nums) {
        int n =  nums.length , idx = n-1;
        int ans[] =  new int[n];
        int i =0 , j =  n-1;
        while( idx>=0 ){
            if(nums[i]*nums[i] >= nums[j]*nums[j] ){
                ans[idx--] =  nums[i]*nums[i];
                i++;
            }
            else{
                ans[idx--] =  nums[j]*nums[j];
                j--;
            }
        }
            
          
        return ans;        
    }
}
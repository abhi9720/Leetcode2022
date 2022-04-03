class Solution {
    
    // ![image](https://assets.leetcode.com/users/images/f16499c9-c11e-44ed-b44e-140dd35cae49_1648990078.3700552.jpeg)

    public void nextPermutation(int[] nums) {
        int n  =  nums.length;
        int i =  n-1;
        int p1 =  n;
        while(i>0){
            if( nums[i-1] < nums[i] ){
              p1 =  i-1;
              break;
            }
            i--;
        }
        if(i==0){
            reverse(nums,0,n-1);
            return ;
        }
         
        // now find point which is greater
        int j =  n-1;
        while( j>p1 ){
            if( nums[j] > nums[p1] ){
                break;
            }
            j-=1;
        }
        // swap
        int t =  nums[p1];
        nums[p1] =  nums[j];
        nums[j] =  t;
        // reverse from p+1
        reverse(nums,p1+1,n-1);

    }
    void reverse(int nums[],int i , int j){
        while(i<j){
            int t =  nums[i];
            nums[i] = nums[j];
            nums[j] =  t;
            i++;j--;
        }
    }
}
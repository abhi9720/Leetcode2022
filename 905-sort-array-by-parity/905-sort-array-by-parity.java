class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // int arr[] =  new int[nums.length];
        // int idx1 = 0, idx2 = nums.length-1;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]%2==0 ){
        //         arr[idx1++] =  nums[i];
        //     }
        //     else{
        //         arr[idx2--] =  nums[i];
        //     }
        // }
        // return arr;
        // with out extra space 
        int i =  0, e = 0;
        while(i<nums.length){
            if(nums[i]%2==0){
                swap(nums,i,e);                
                e++;
            }
            i++;
                
        }
        return nums;
    }
    private void swap(int arr[], int i, int j){
            int t =  arr[i];
            arr[i]  =  arr[j];
            arr[j] =  t;
        }
}
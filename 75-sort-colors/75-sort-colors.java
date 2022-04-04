class Solution {
    public void sortColors(int[] nums) {
        int p1=  0 , p2 =  nums.length-1;
        int i =0;
        while(i<=p2){
            if(nums[i]==0 ){
                swap(nums,i,p1);
                i++;
                p1++;
            }
            else if(nums[i]==2 ){
                swap(nums,i,p2);
                p2--;                
            }
            else{// 1 found 
                i++;
            }
        }                    
    }
    void swap(int nums[], int i , int j){
        int t =  nums[i];
        nums[i] =  nums[j];
        nums[j] =  t;
    }
}
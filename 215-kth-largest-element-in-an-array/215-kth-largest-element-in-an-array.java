class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int left =  0, right=nums.length-1;
        while(left<=right){
            
            int idx =  partitionArray(nums,left,right);
            
            if(idx+1==k){
                return nums[idx];
            }else if(idx+1 > k){
                right =  idx-1;
            }else{
                left =  idx+1;
            }          
            
        }
        
        return -1;
    }
    
    int partitionArray(int nums[] , int left, int right){
        // partition index 
        int pidx =  right;
        int pele =  nums[pidx];
        
        int storeIdx = left;
        for(int i =  left ; i<=right;i++){
            if(nums[i] > pele ){
                swap(nums, storeIdx , i);
                storeIdx++;                    
            }
        }
        // swap partion element 
        swap(nums,storeIdx , pidx);
        
        
        
        return storeIdx;
    }
    private void swap(int nums[], int a ,int b){
        int t =  nums[a];
        nums[a] =  nums[b];
        nums[b] = t;
    }
}
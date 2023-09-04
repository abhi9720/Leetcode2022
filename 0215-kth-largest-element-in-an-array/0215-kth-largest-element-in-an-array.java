class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int low =  0;
        int high = nums.length-1;
        while(low <= high){
            int index =  partition(nums,low,high);
            if(index==k-1) return nums[index];
            else if(index > k-1) high =  index-1;
            else low =  index+1;
        }
       
        return -1;
        
    }
    
    public int partition(int nums[], int i , int j){
        
       
       
        Random rand = new Random();
        int pid = rand.nextInt(j - i + 1) + i;
        
        swap(nums,pid,j);
        int pivot = nums[j];
        int pivotloc =  i;
        
        while(i<=j){
            if(nums[i]> pivot){
                
                swap(nums, pivotloc ,i);
                pivotloc++;
            }
            i++;
        }
        
        nums[j] =  nums[pivotloc];
        nums[pivotloc]  =  pivot;
        
        return pivotloc;
        
    }
    
    private void swap(int nums[], int i , int j){
        int temp =  nums[i];
        nums[i] = nums[j];
        nums[j] =  temp;
    }
}
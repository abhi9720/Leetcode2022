class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int c = 0;
        int count = 0;
        int prev = 0;
        
        for(int ele : nums){            
            
            if(ele >= left && ele<=right){                
                c++;
                count+=c;                
                prev = c;                                
            }
            else if(ele < left){
                count+=prev;
                c++;
            }
            else{
                c = 0;   
                prev = 0;
            }                        
            
            
            
        }
        return count;
    }
}
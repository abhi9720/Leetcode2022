class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int ridx =  findRotateIndex(nums);
        
        int l = 0;
        int r = n-1;
        
        while(l<=r){
            int orginalmid =   l+(r-l)/2 ;
            int m = (orginalmid + ridx )%n;
            if(nums[m]==target) return m;
            else if(nums[m]>target){
                r =  orginalmid -1;
            }
            else{
            l =  orginalmid+1;
            }
        }
        return -1;
        
    }
    
    int findRotateIndex(int nums[]){
        int n =  nums.length;
        int l = 0 , r =  nums.length-1;
        
        while(l<=r){
            int m = l+(r-l)/2;
            
            int lidx  =  ((m-1)+n)%n;
            int ridx =  (m+1)%n;
            
            if( nums[m]<nums[lidx] && nums[m]<nums[ridx]  ){
                return m;
            }
            else if(nums[m] > nums[r]){
                l=  m+1;
            }
            else {
                r =  m-1;
            }
            
          
            // else if( nums[m]>nums[lidx] && nums[m]<nums[ridx]){
            //     l = ridx; 
            // }
            // else{
            //     r = lidx;
            // }
        }
        
        return l;
        
    }
}

// 4,5,6,7,0
// 0,4,5,6,7
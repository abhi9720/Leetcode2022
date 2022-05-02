class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i = 0, j = 0, n =  nums.length;
        int max  =  nums[0];
        int count = 0;
        int c  = 0;
        while(j<n){
            // acquire
           int x =inrange(nums[j],left,right);
                if( x==0){
                    count+=(j-i+1);
                    c=(j-i+1);
                
                                        
            } else if(x==-1){
                count+=c;
            }
            else{                               
                i=j+1;
                c=0;                
            }
            j++;
            
            
            // release
        }
        return count;
    }
    private int inrange(int ele , int left, int right){
        if(ele > right) return 1;
        else if(ele < left) return -1;
        else return 0;
    }
}
// ,5,55,14,9,7,72,52
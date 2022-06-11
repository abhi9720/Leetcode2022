class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int k1 =  countAtMostK(nums,k)  ;        
        int k2 = countAtMostK(nums,k-1);
        
        return k1-k2;
    }
    private int countAtMostK(int nums[], int k){
        int i= 0, j = 0;
        int res =0;
        while(j<nums.length){            
            if(nums[j] %2==1 ) k-=1;
            while(i<nums.length && k<0){
                if(nums[i]%2==1 ) k++;
                i++;
            }    
            
            res+=(j-i+1);
            j++;
        }
        return res;
    }
}
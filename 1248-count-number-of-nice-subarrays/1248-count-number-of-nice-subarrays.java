class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0, i = 0, total = 0;
        for(int j=0;j<n;j++){
            if(nums[j]%2==1){
                k--;
                count = 0;
            }
            
            while(k==0){
                k += nums[i++]&1;
                count++;
            }
            
            total += count;
            
        }
        
        return total;
    }
}
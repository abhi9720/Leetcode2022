class Solution {
    long MOD =  1000000007L;
    public int sumSubseqWidths(int[] nums) {
        long sum  = 0;
        Arrays.sort(nums);
        long pow =  1;
        int i = 0 , j =  nums.length-1;
        int n  =  nums.length;
        while(i<n && j>=0){
            sum  =   (sum + nums[i]*pow -  nums[j]*pow)%MOD;            
            pow =  (pow*2)%MOD;            
            i++;
            j--;
        }
        return (int)sum;
        
    }
}
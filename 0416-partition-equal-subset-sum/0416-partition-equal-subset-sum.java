class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums){
            sum+=ele;
        }
        if(sum%2==1) return false;
        int target =  sum/2;
        int n  =  nums.length ;
        boolean dp[][] =  new boolean[n+1][target+1];;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(i==0 || j==0){
                    if(i==0) dp[i][j] =  false;
                    if(j==0) dp[i][j] =  true;
                }
                else if( nums[i-1] <=j  ){
                    dp[i][j] =  dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] =  dp[i-1][j];
                }
            }
        }
        return dp[n][target];        
    }
}
// KnapSack pattern 
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n =  nums.length;
        for(int ele : nums){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        sum =  sum/2;
        boolean dp[][] =  new boolean[n+1][sum+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0 || j==0){
                    if(i==0) dp[i][j] = false;
                    if(j==0) dp[i][j] =  true;
                }
                else if( nums[i-1]<= j ){
                    dp[i][j]=  dp[i-1][j -  nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] =  dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
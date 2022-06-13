class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n =  triangle.size();
        int dp[][] =  new int[n][n];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        
        memoization(triangle,dp,0,0);   
        return dp[0][0];
    }
    private int memoization(List<List<Integer>> triangle ,int dp[][], int l , int idx ){
        if(l==triangle.size()-1 ){
            return dp[l][idx] = triangle.get(l).get(idx);
        }
        if(dp[l][idx]!=-1 ){
            return dp[l][idx];
        }
        
        int left =  memoization(triangle,dp,l+1,idx);
        int right =  memoization(triangle,dp,l+1,idx+1);
        return dp[l][idx] = Math.min(left,right)+triangle.get(l).get(idx);
    }
}
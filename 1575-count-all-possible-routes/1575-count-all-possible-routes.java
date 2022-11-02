class Solution {

    static int mod =  (int)1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        dp = new int[locations.length+1][fuel+1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        
        int ans =  dfs(locations, start, finish, fuel);
        
        return ans;
        
    }

    int dp[][];

    private int dfs(int locations[], int start, int end, int fuel) {
        int count = 0;
        if (start == end) {
            count++;
        }
        
        if(dp[start][fuel]!=-1){
            return dp[start][fuel];
        }

        // now from this start check all possible end
        for (int i = 0; i < locations.length; i++) {
            if (i != start) {
                int leftFuel = fuel - Math.abs(locations[i] - locations[start]);
                if (leftFuel >= 0) {
                   count= (count + dfs(locations, i, end, leftFuel))%mod;
                }
            }
        }
        return dp[start][fuel] =  count;
    }
}

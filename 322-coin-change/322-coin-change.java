class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int prev[] = new int[amount+1];
        Arrays.fill(prev,Integer.MAX_VALUE-10);
        prev[0] =  0;
        for(int i=0;i<coins.length;i++){
            int curr[] =  new int[amount+1];
            for(int amt=1;amt<=amount;amt++ ){
                if(amt< coins[i] ){
                    curr[amt] =  prev[amt];
                }
                else{
                    curr[amt] =  Math.min( prev[amt], 1+curr[amt -coins[i] ] );
                }
            }            
            prev =  curr;
        }
        return prev[amount]==2147483637?-1:prev[amount];
    }
}
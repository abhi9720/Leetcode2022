class Solution {
    public int coinChange(int[] coins, int amount) {
        int amt[]  =  new int[amount+1];
        // amt[i] = minimum number of coins require to make amount i
        
        for(int i=1;i<=amount;i++){
            int minCoins = -1;;
            for(int coin : coins ){
                if( coin <= i  && amt[i-coin]!=-1 ){
                    int req =  amt[i-coin]+1;
                    minCoins =  minCoins<0?req:Math.min(minCoins,req);
                }
            }
            amt[i] = minCoins;
        }
     return amt[amount];
    }
}
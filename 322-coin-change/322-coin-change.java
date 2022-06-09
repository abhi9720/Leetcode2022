class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int prev[] = new int[amount+1];
        Arrays.fill(prev,-1);
        prev[0] =  0;
        for(int i=0;i<coins.length;i++){
            int curr[] =  new int[amount+1];
            for(int amt=1;amt<=amount;amt++ ){
                if(amt< coins[i] ){
                    curr[amt] =  prev[amt];
                }
                else{
                    // curr[amt] =  Math.min( prev[amt], 1+curr[amt -coins[i] ] );
                    int without =  prev[amt];
                    int with =  curr[amt -coins[i] ];
                    // System.out.println(without+"  "+with);
                    if(with==-1){
                        curr[amt]=  without;
                    }
                    else if(without==-1){
                        curr[amt] = 1+with;
                    }
                    else{
                        curr[amt] =  Math.min(without,1+with);
                    }
                    // curr[amt] =  without==-1? with : Math.min(without,with);
                    // System.out.println(coins[i]+" , "+amt+"   => "+ curr[amt] );
                    // System.out.println("----------------------");
                }
            }            
            prev =  curr;
        }
        
        return prev[amount];
    }
}
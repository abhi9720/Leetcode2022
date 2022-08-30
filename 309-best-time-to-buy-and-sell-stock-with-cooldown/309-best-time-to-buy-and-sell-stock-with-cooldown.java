class Solution {
    public int maxProfit(int[] prices) {
        int n  =  prices.length;
        int b1 =  -prices[0] , s1 = 0 , c1 = 0; 
        /*
        buy[i]=  max( previous buy , buy after cooldown)
        sell[i] =  max( previous_sell , price[i] - previous_buy  )
        cooldown[i] =  maximum profit of any sequence if day i is cooldown
        which will be max of previous_cooldown , previous_sell
        
        */
        for(int i=1;i<n;i++){
            
            int b2 = Math.max(-prices[i]+c1 , b1);
            
            int s2 = Math.max( b1+prices[i] , s1 );
            int c2 =  Math.max(c1,s1);
            c1 =  c2;
            s1 =  s2;
            b1 =  b2;
        }
        return s1;
    }
}
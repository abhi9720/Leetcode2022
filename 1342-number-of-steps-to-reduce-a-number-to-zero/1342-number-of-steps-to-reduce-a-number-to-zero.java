class Solution {
    public int numberOfSteps(int n) {
     
/*
if even then divide by 2
else if odd then subtract  1 

even : 1010 -> 101 -> 100->10->1->0 ,    step : 4
odd  : 1001 -> 1000 -> 100-> 10->1->0 ,  step : 5

::: to check odd or even 
        if n&1==0 means even 
        otherwise odd


    1)  reduce by 1: do xor
            1001
          ^
            0001
          --------
            1000
          ---------            
    2)   divide by 2: right shift by 1 bit 
             1010>>1  => 101
*/
        int steps =0;
        while(n!=0){
            if( (n&1) ==0){
              n = (n>>1);
            }
            else{
                n^=1;
            }   
            steps++;
        }
        return steps;
        
        
        
        
        
    }
}
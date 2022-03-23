class Solution {
    public int brokenCalc(int startValue, int target) {
        int count  = 0;
        while(startValue < target){
            if(target%2==0) target/=2;
            else target+=1;
            count++;
        }
        return count+( startValue - target  );
    }
}

/*
why doing subtraction and multiplication is not deterministic

If with subtraction and multiplication, the effect of earlier subtraction will be amplified by later multiplications, hence, greedily doing multiplication might not reach optimal solution as an additional early subtraction can have a huge effect.
Whereas with addition and division, earlier addition will be diminished by later divisions. It is thus always better to do division wherever possible.

 public int brokenCalc(int startValue, int target) {
        
        int countOp = 0;
        while( startValue < target ){
            int twice =  2*startValue;
            int minusOneTwice  =  (startValue-1)*2;
            
            if( twice < target ){
                startValue =  twice;
                countOp++;
            }
            
            else{
                int diff1 =  Math.abs( target-twice );
                int diff2 = Math.abs( target - minusOneTwice );
                if(diff1 <= diff2){
                  startValue =  twice;  
                    countOp++;
                }else{
                    startValue =  minusOneTwice;
                    countOp+=2;
                }
                
            }
        }
        return countOp+(startValue-target);
        
        
        
        
    }
    
*/
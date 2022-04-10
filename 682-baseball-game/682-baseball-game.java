import java.math.BigInteger;
class Solution {
    public int calPoints(String[] ops) {
        String []stk  =  new String[ops.length];
        int ptr =  0;
        for(String op : ops){
            if(op.equals("+") ){
                BigInteger num1  =  new BigInteger(stk[ptr-1] );
                BigInteger num2  =  new BigInteger(stk[ptr-2] );
                num1  =  num1.add(num2);
                stk[ptr++] =  num1.toString();                                
            }else if(op.equals("C") ){
                ptr-=1;
                stk[ptr] =  null;                
            }
            else if( op.equals("D") ){
                BigInteger num1  =  new BigInteger(stk[ptr-1] );
                BigInteger bi2 = BigInteger.valueOf(2L);
                num1 =  num1.multiply(bi2);
                stk[ptr++] =  num1.toString();                
            }
            else{
                stk[ptr++] =  op;
            }        
       }   
        
        int ans=0;
        while(ptr-->0){
            ans  =  ans + Integer.valueOf( stk[ptr] );
        }
        
        return ans;
    }
    
}
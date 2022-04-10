import java.math.BigInteger;
class Solution {
    public int calPoints(String[] ops) {
        String []stk  =  new String[ops.length];
        int ptr =  0;
        for(String op : ops){
            if(op.equals("+") ){
                int num1 =  Integer.parseInt(stk[ptr-1] );
                int num2 =  Integer.parseInt(stk[ptr-2] );
                stk[ptr++] =  String.valueOf(num1+num2);
                                               
            }else if(op.equals("C") ){
                ptr-=1;
                stk[ptr] =  null;                     
            }
            else if( op.equals("D") ){
                int num1 =  Integer.parseInt(stk[ptr-1] );
                stk[ptr++] =  String.valueOf(num1*2);
            }
            else{
                stk[ptr++] =  op;
            }        
       }   
        
        int ans=0;
        while(ptr-->0){
            ans  =  ans + Integer.parseInt( stk[ptr] );
        }
        
        return ans;
    }
    
}
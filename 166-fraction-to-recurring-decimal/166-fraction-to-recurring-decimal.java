class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0) return "";
        
        HashMap<Long,Integer> map =  new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        
        if( (numerator<0  && denominator>0)|| (numerator>0  && denominator<0) ){
            sb.append("-");
        }
        
        
        
        long  numer  =  numerator;
        long denom =    denominator;
        
        sb.append( Math.abs(numer / denom ) );
        long r = Math.abs( numer % denom) ;
        
        if(r==0){
            return sb.toString();
        }
            
        StringBuilder decimal = new StringBuilder(".");
        int idx = 1;
        while(true && r!=0 ){
            long n =  r*10;
            long newR   =  n   % denom;
            long newQ =  n  / denom;
            
            
            decimal.append( Math.abs(newQ) );            
            if(map.containsKey( newR )  ){
                r =  newR ;
                break;
            }
            
            map.put( newR ,  idx  );
            idx++;
            r = newR;
                
        }
        
        if(r==0){
            sb.append(decimal);
        }
        else{
        //          case like 1.2(6)  -  herer 6 repeat so only 6 comes in bracket
        String repeat =  decimal.substring(map.get(r)+1 );
        String pre =  decimal.substring(0,map.get(r)+1 );                
        sb.append(pre );
        sb.append("("+repeat+")");            

        }

        return sb.toString();
        
    }
}
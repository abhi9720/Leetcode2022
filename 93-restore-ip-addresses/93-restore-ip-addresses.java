class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans =  new ArrayList<>();
        helper(s,ans,"",3 );
        return ans;
    }
    
    private void helper(String s, List<String> ans, String ip, int pos){
        
        // System.out.println(ip);
        if(s.length()==0){
            if(pos==-1)
            ans.add( ip );
            return ;
        }
        
        
        // range 0 to 255
       // decide current point  1len , 2len , 3len
       // if len greater than 1 , no leading zero
       for(int i=0;i<Math.min(3,s.length() );i++ ){
           String bit =  s.substring(0,i+1);
           String remain =  s.substring(i+1);
           // System.out.println(pos+" -> bit : "+bit);
           // System.out.println(pos+" -> remain : "+remain);
           
           if(valid(bit,remain,pos)){
               
               helper(remain,ans,ip.length() >0? ip+"."+bit:bit,pos-1);
           }
           
       }
        
    }
    
    private boolean valid(String bit, String remain, int pos){
        if(remain.length() > pos*3 ) return false;
        if(bit.length() >1 && bit.charAt(0)=='0' )  return false;
        int num  =  Integer.parseInt(bit);
        return num>=0 && num<=255;
    }
}
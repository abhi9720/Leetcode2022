class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set  =  new HashSet<>();
        for(int i=0;i+k<=s.length();i++ ){
            set.add(s.substring(i,i+k) );
        }
        
        
        for(int i=0;i< (1<<k);i++){
            String code =  Integer.toBinaryString(i);
            if(code.length()<k ){
                int diff =  k -  code.length();
                code = "0".repeat(diff) +code;                
            }
            
            if(!set.contains(code) ) return false;
        }
        return true;        
    }
}
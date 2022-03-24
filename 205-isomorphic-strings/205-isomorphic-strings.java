class Solution {
    public boolean isIsomorphic(String s, String t) {
 
        if(s.length()!=t.length()) return false;
        char mapStoT[] =  new char[128];
        char mapTtoS[]=  new char[128];
        
        for(int i=0;i<s.length();i++ ){
            mapStoT[s.charAt(i)] =  t.charAt(i);
            mapTtoS[t.charAt(i)] =  s.charAt(i);            
        }
        for(int i=0;i<s.length();i++){
            if(!( mapStoT[s.charAt(i)]==t.charAt(i) && mapTtoS[t.charAt(i)]== s.charAt(i) ) ){
                return false;
            }
        }
        return true;
        
    }
}
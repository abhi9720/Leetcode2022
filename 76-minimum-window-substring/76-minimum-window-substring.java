class Solution {
    public String minWindow(String s, String t) {
        // Algorithm 
        /*
            1. 
        
        */
        if(t.length() > s.length()) return "";
        Integer map[] =  new Integer[130];
        int missing =  0 , minLen =  s.length()+1;
        
        for(int i=0;i<t.length();i++){
            int idx =  t.charAt(i) ;
            
            if( map[idx]== null ){
                missing++;
            }
            map[idx] = (map[idx]==null?1:map[idx]+1);
        }
        int start = 0  ;
        
        int i=0, j =0;
        while(j< s.length() ){
            if( map[s.charAt(j)] != null){                       
                map[s.charAt(j)]--;
                if(map[s.charAt(j) ]  == 0){
                    missing-=1;
                }
                
                while(missing ==0 ){
                    // remove char at ith index
                    int chi =  s.charAt(i);
                    if(map[chi]!=null ){
                        map[chi]++;
                        if(map[chi] >0 ){
                            missing+=1;
                        }
                    }
                    
                    if(  j-i+1 < minLen  ){
                        minLen =  j-i+1;
                        start =  i;
                    }
                    i++;
                }
            }
            j++;
        }
        return minLen ==s.length()+1 ?"": s.substring(start,start+minLen);
        
    }
}
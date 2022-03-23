class Solution {
    public String minWindow(String s, String t) {
        // Algorithm 
        /*
            1. 
        
        */
        if(t.length() > s.length()) return "";
        HashMap<Character,Integer> map =  new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put( t.charAt(i), map.getOrDefault(t.charAt(i),0)+1 );
        }
        int start = 0  ;
        int missing =  map.size() , minLen =  s.length()+1;
        int i=0, j =0;
        while(j< s.length() ){
            if(map.containsKey(s.charAt(j)) ){                
                map.put(s.charAt(j) , map.getOrDefault(s.charAt(j) , 0 ) - 1 );
                if(map.get(s.charAt(j))  == 0){
                    missing-=1;
                }
                
                while(missing ==0 ){
                    // remove char at ith index
                    char chi =  s.charAt(i);
                    if(map.containsKey(chi) ){
                        map.put( chi , map.get(chi)+1 );
                        if(map.get( chi ) >0 ){
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
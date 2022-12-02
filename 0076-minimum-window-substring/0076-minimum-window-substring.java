class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int i=0, j=0;
        HashMap<Character,Integer> map =  new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch , map.getOrDefault(ch,0)+1 );
        }
        
        int missing =  t.length();
        int minLen =  s.length()+1;
        String ans =  "";
        while(i<s.length()){
            
            if(map.containsKey(s.charAt(i)) ){
                map.put(s.charAt(i) , map.get(s.charAt(i) )-1 );
                if(map.get(s.charAt(i) )>=0){
                    missing--;
                }                                
            }
            
            while(missing==0){
                int len =  i-j+1;                
                
                if(len<minLen){
                    minLen =  len;
                    ans =  s.substring(j,i+1);
                }
                char rm = s.charAt(j);
                if(map.containsKey(rm) ){
                    map.put(rm , map.get(rm)+1);
                    if(map.get(rm)>0 ){
                        missing++;
                    }
                }
                j++;
            }
            
            
            i++;
        }
        return ans;
    }    
}
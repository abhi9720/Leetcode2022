class Solution {
    public int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
         HashMap<Integer, Integer> map =  new HashMap<>();
        return helper(s,map);
         
    }
    
    public int helper(String s ,  HashMap<Integer, Integer> map ){
        if(s.length()==0){
            return 1;
        }
        
         int check   = map.getOrDefault(s.length(),-1);
        if(check!=-1) return check;
        
        
        int count = 0;
        if(s.charAt(0)!='0'){
            count+=helper(s.substring(1),map);

        }
        if(s.length()>=2) {
            int num  =  (s.charAt(0)-'0')*10+(s.charAt(1)-'0');
            if(num>=10 && num <=26){
                count+=  helper(s.substring(2),map);
            }
        }
         map.put(s.length(),count);
        return count;
    }
}
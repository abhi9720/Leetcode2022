class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character,String> charToString =  new HashMap();
        HashMap<String,Character> stringToChar =  new HashMap();    
        
        String arr[] =  s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        
        for(int i=0;i<pattern.length();i++){
            Character ch  =  pattern.charAt(i);
            String str =  arr[i];
            String pre =  charToString.put(ch,str);
            if(pre!=null && (!pre.equals(str)) ){
                return false;
            }
            Character prechar =  stringToChar.put(str,ch);
            
            if(prechar!=null && prechar!=ch){
                return false;
            }
            
            
        }
        
        return true;
    }
}
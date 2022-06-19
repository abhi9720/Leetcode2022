class Solution {
    public String longestCommonPrefix(String[] strs) {

        return optimise_code(strs);
    }
    private String optimise_code(String strs[]){
        if(strs==null || strs.length==0) return "";
        String prefix=   strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0)    {
                prefix  =  prefix.substring(0,prefix.length()-1);
                }
            
        }
        return prefix;                 
    }
    
    
}









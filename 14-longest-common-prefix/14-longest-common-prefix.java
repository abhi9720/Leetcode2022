class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int n =  strs.length;    
        // find min len 
        String prefix =  strs[0];
        for(int i=0;i<n;i++){
            if(  prefix.length() > strs[i].length() ){
                prefix =  strs[i];
            }
        }
        for(int i=0;i<n;i++){
            // compare prefix and strs[i] from start
            int j=0;
            String str =  strs[i];
            while(j<Math.min(prefix.length() , str.length() ) ){
                if(prefix.charAt(j) != str.charAt(j) ) break;
                j++;
            }
            prefix = prefix.substring(0,j);                        
            if(prefix.length()==0 ) break;
        }
        return prefix;
    }
}
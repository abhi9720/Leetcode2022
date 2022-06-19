class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs , (s1,s2)->{
            return s1.length() - s2.length();
        });
        String prefix =  strs[0];
        int n =  strs.length;
        
        for(int i=1;i<n;i++){
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
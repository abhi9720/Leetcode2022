class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        int len1 =  s.length() , len2 = t.length();
        if(len1 > len2) return false;
        while(i<len1 && j<len2){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        
        
        return i==len1;        
    }
}
class Solution {
    public int lengthOfLastWord(String s) {
        int n  =  s.length();
        int j =  n-1;
        
        while(j>=0 && s.charAt(j)==' ' ) j--;
        int len= 0;
        while(j>=0 && s.charAt(j)!=' ' ){
            len++;
            j--;
        }
        return len;            
    }
}
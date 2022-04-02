class Solution {
    public boolean validPalindrome(String s) {
        int n =  s.length();
        int i =  0 , j =  n-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j) ){
                return checkRemaining(s,i,j-1 ) || checkRemaining(s,i+1,j);
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean checkRemaining(String s, int i , int j){
        while(i<j ){
            if(s.charAt(i)!=s.charAt(j) ) return false;
            i++;
            j--;
        }
        return true;
    }        
}
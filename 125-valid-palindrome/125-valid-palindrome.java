class Solution {
    private boolean isValid(char ch){
        return ((ch>='a' && ch<='z') || (ch>='0' && ch<='9'));        
    }
   public boolean isPalindrome(String s) {
        int countOdd = 0;
        int i = 0, j =  s.length()-1;
        int n =  s.length();
        while(i<j){
            while( i<n && !isValid(Character.toLowerCase(s.charAt(i) )) ){
                i++;
            }
            
            while(j>=0 && !isValid(Character.toLowerCase(s.charAt(j) )) ){
                j--;
            }            
            
            if(i<j && Character.toLowerCase(s.charAt(i) )  != Character.toLowerCase(s.charAt(j) )){
                return false;
            } 
            i++;
            j--;
        }
       return true;
        
   }
}
 
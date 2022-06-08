class Solution {
    public int removePalindromeSub(String s) {
        if(s==null || s.length()==0 ) return 0;
        int i=0, j =  s.length()-1;
        boolean isPalin =  true;
        while(i<j){
            if(s.charAt(i)!= s.charAt(j) ){
                isPalin =  false;
            }
            i++;
            j-=1;
        }
        if(isPalin) return 1;
        else return 2;
    }
    
    
    
}
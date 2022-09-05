class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n1 =  s.length(),n2 =  t.length();
        int i = n1-1;
        int j =  n2-1;
        int c1 = 0,c2 =0;
        while( i>=0 || j>=0 ){
            
            //backspace count 
            c1 = 0;            
            for(;i>=0;i--){                
                if(s.charAt(i)=='#' ){ c1++;}
                else if( c1>0 ){c1--;}   // do backspace
                else break;
            }
            
            //backspace count 
            c2 = 0;
            for(;j>=0;j--){                
                if(t.charAt(j)=='#' ){ c2++;}
                else if( c2>0 ){c2--;}                
                else break;
            }
            
            

            if( i>=0 && j>=0 && s.charAt(i) == t.charAt(j) ) {
                i--;
                j--;
            }
            else break;
            
            
        }
        return i == -1 && j == -1;
    }
}
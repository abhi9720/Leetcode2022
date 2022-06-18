class Solution {
    public String reverseWords(String s) {
        StringBuilder sb =  new StringBuilder();
        s  =  s.trim();        
        int n   =  s.length();
        int j =  n;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==32){
                if(j-i==1){ j = i; continue;}
                sb.append(s.substring(i+1,j) );
                sb.append(" ");
                j =  i;
            }
            else if(i==0){                
                sb.append(s.substring(i,j) );
            }
        }
        return sb.toString();
        
    }
    
    
}
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb =  new StringBuilder();
        
        
        int n   =  s.length();
        
        
        int r =  n-1, l=0;
        while(r>=0 && s.charAt(r)==32 )r--;
        while(l<n && s.charAt(l)==32) l++;
        int j =  r+1;
        
        for(int i=r;i>=l;i--){
            if(s.charAt(i)==32){
                if(j-i==1){ j = i; continue;}
                sb.append(s.substring(i+1,j) );
                sb.append(" ");
                j =  i;
            }
            else if(i==l){                
                sb.append(s.substring(i,j) );
            }
        }
        return sb.toString();
        
    }
    
    
}
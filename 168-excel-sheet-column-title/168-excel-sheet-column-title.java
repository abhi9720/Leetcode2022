class Solution {
    public String convertToTitle(int columnNumber) {
        
       return helper(columnNumber).toString();
    }
    private StringBuilder helper(int columnNumber){
        
        if(columnNumber<=26){        
            StringBuilder sb =  new StringBuilder();
            char ch = (char)('A'+columnNumber-1);
            sb.append(ch);
            return sb;
        }
        int mod =  columnNumber%26;
        int nextnum =  columnNumber/26;
        if(mod==0){
            mod =  26;
            nextnum-=1;
        }
        StringBuilder sb =  new StringBuilder();
        sb.append(helper(nextnum));
        sb.append( (char)('A'+mod-1) );
        
        return sb;
        
    }
}
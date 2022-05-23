class Solution {
    public String convertToTitle(int columnNumber) {
        
        if(columnNumber<=26){            
            return ""+(char)('A'+columnNumber-1);
        }
        int mod =  columnNumber%26;
        int nextnum =  columnNumber/26;
        if(mod==0){
            mod =  26;
            nextnum-=1;
        }
        return   convertToTitle(nextnum)+(char)('A'+mod-1);
        
    }
}
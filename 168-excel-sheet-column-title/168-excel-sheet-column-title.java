class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        while(columnNumber >0){            
            int idx =  columnNumber%26;
            columnNumber/=26;
            if(idx==0){
                idx = 26;                
                columnNumber-=1;
            }
            
            
            sb.append((char)(idx-1+'A'));
        }
        
        return sb.reverse().toString();
    }
}

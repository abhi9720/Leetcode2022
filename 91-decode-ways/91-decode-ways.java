class Solution {
    public int numDecodings(String s) {
        int iminus2  =  0;
        int iminus1  =  1;
        int  n =  s.length();
        for(int i=n-1;i>=0;i-- ){
            int count  = 0;
            char ch =  s.charAt(i);
            if(ch!='0'){
                count+=iminus1;
                if(i<s.length() -1){
                    int num =  (ch-'0')*10+(s.charAt(i+1) - '0') ;
                    if(num<=26){
                        count+=iminus2;
                    }
                }
            }
            
            int ith =  count;
            iminus2 =  iminus1;
            iminus1 =  ith;
        }
        return iminus1;
        
    }
}
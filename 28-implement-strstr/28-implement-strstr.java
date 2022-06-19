class Solution {
    public int strStr(String haystack, String needle) {
        return KMP(haystack, needle);
    }
    
      private  int KMP(String src, String pattern){

        int loopup[] =  createLookUpTable(pattern);
        int i = 0, j = 0;
        while(i<src.length() && j<pattern.length()){
            if(src.charAt(i)==pattern.charAt(j)){
                
                i++;
                j++;                
            }
            else{
                if(j>0){
                    j =  loopup[j-1];
                }
                else{
                    i++;
                }
            }
            if(j==pattern.length()){                
                return i-j;
            }
        }
        return -1;
    }


    private  int[] createLookUpTable( String pattern){
        int lookup[] =  new int[pattern.length()];
        int i = 1;
        int index = 0;
        while(i<pattern.length() ){
            if(pattern.charAt(i)== pattern.charAt(index) ){
                lookup[i] =  index+1;
                index++;
                i++;
            }
            else{
                if(index>0){
                    index = lookup[index-1];
                }
                else{
                    lookup[i]  = 0;
                    i++;
                }
            }
            
        }
        return lookup;
    }
}
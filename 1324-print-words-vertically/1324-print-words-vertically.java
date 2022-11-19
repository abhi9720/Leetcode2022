class Solution {
    public List<String> printVertically(String s) {
        
        int maxLen = 0, maxLenStringIndex = -1;
        String arr[]  =  s.split(" ");
        
        for(int i=0;i<arr.length ;i++){            
            int len  =  arr[i].length() ;
            if(len >= maxLen){
                maxLen =  len;
                maxLenStringIndex =  i;
            }            
        }
        
        List<String> output  =  new ArrayList<>();
        int j=0;
        while(j<maxLen){
            StringBuilder  sb   =  new StringBuilder();
            for(int i=0;i<arr.length;i++ ){
                if(j<arr[i].length()){
                    sb.append(arr[i].charAt(j));
                }
                else{                    
                        sb.append(" ");                    
                }
            }
            
            int itr =  sb.length()-1;
            while(itr>=0 && sb.charAt(itr)==' '){
                itr--;
            }
            sb.setLength(itr+1);
            output.add(sb.toString());
            j++;
        }
        return output;
        
    }
}
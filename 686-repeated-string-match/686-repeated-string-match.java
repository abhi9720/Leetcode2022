class Solution {

    public int repeatedStringMatch(String s, String p) {
        
        int count = 1;
        String src = s;
        while(src.length() < p.length() ){
            count+=1;
            src+=s;
        }
        
        if(src.contains(p) ) return count;
        src+=s;
        if(src.contains(p) ) return count+1;
        
        return -1;
        
        
    }
   
}

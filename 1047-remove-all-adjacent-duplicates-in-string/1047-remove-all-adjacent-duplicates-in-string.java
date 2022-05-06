class Solution {
    public String removeDuplicates(String s) {
        char ch[] = new char[s.length()];
        ch[0] = s.charAt(0);
        int i=0;
        for(int j=1;j<s.length();j++ ){
            if(i>=0 && s.charAt(j)==ch[i] ){
                i-=1;
            }
            else{
                ch[++i] = s.charAt(j);
            }
        }
        return new String(ch,0,i+1);
        
        
    }
}
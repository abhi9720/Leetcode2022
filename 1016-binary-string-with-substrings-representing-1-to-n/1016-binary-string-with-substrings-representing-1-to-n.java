class Solution {
    public boolean queryString(String s, int n) {
        
        for(int i=1;i<=n;i++){
            String bin =  Integer.toBinaryString( i );
            int idx = s.indexOf(bin);
            if(idx==-1) return false;
        }
        return true;        
    }
}
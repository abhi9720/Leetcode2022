class Solution {
    public boolean queryString(String s, int n) {
        if(s.equals("1") && n==1) return true;
        
        for(int i=n;i>=n/2;i--){
            String bin =  Integer.toBinaryString( i );
            int idx = s.indexOf(bin);
            if(idx==-1) return false;
        }
        return true;        
    }
}

class Solution {
    public boolean queryString(String s, int n) {
        HashSet<String> set =  new HashSet<String>();
        for(int i =0 ; i< s.length();i++ ){
            for(int j=i+1;j<=Math.min( s.length() , i+30 ) ;j++){
                set.add( s.substring(i,j) );
            }
        }
        for(int i=1;i<=n;i++){
            String bin =  Integer.toBinaryString( i );
            if(!set.contains(bin) ){
                return false;
            }
        }
        return true;        
    }
}
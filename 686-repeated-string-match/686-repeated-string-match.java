class Solution {

    public int repeatedStringMatch(String s, String p) {
        
        int count = 1;
        String src = s;
        while(src.length() < p.length() ){
            count+=1;
            src+=s;
        }
        if(src.equals(p) ) return count;
        if(rabinkarp(src,p)!=-1 ) return count;
        if(rabinkarp(src+s,p)!=-1 ) return count+1;
        return -1;
        
        
    }
       
    public static int rabinkarp(String source, String target) {
        int n = source.length();
        int m = target.length();

        if (n < m) return -1;

        long hSource = 0; // hash of source
        long hTarget = 0; // hash of target
        long base = 31; // base
        long mod = 997; // hash table size , to handle very large number
        
        // preCompute =  base^(N-1) need to remove out of window character
        // as we need to remove out of window digit we multiply it wit char*base^(N-1)
        long preCompute = 1;
        for (int i = 1; i < m; i++) {
            preCompute = (preCompute * base) % mod;
        }

        // calculated intiial hashvalues
        for (int i = 0; i < m; i++) {
            hSource = ((hSource * base) % mod + source.charAt(i)) % mod;
            hTarget = ((hTarget * base) % mod + target.charAt(i)) % mod;
        }

        for (int j = m; j <= n; j++) {
            if (hSource == hTarget) {
                if (source.substring(j - m, j).equals(target)) {
                    return j-m;
                }
            }

            if (j < n) {
                // this is where we are rolling our hash value to calculate next hashvlaue
                // removed out of window character
                hSource = (hSource+mod - (source.charAt(j - m) * preCompute)%mod) % mod;

                // add new character of this window
                hSource = (hSource * base + source.charAt(j )) % mod;
            }
        }
        return -1;
    }    
}

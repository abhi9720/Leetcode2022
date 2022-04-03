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


// class Solution {
//     public boolean queryString(String S, int N) {
//     	Set<Integer> set = new HashSet<>();

//     	for (int i = 0; i < S.length(); i++){
//     		for (int j = Math.max(i - 30, 0); j <= i; j++){
//     			int v = 0;
                
//     			for (int bit = j;bit <= i; bit++) {
//     				v = v * 2 + (S.charAt(bit) - '0');    				
//     			}    	
                
//     			if (v > 0 && v <= N) {
//     				set.add(v);
//     			}    			
//     		}
//     	}
//     	return set.size() == N;    	
//     }
// }
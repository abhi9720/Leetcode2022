class Solution {
    public boolean isValid(String S) {
        String abc = "abc";
    	
    	while(S.contains(abc)) {
    		S = S.replace(abc, "");
    	}
    	
        return S.isEmpty();
            
    }
}
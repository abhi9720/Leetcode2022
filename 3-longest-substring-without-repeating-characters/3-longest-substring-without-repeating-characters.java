class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // keep a hashset 
        // sliding window technique , if char repaet , keep global maximum of such window length
        int i = 0, j = 0 , len  = 0, maxLen =  0;
        HashSet<Character> set =  new HashSet<>();
        while(i<s.length() ) {
                 while(set.contains(s.charAt(i) ) ){
                    set.remove(s.charAt(j) );
                    j++;
                }                
            

            if(!set.contains( s.charAt(i) ) ){
                set.add(s.charAt(i) );
                i++;
                len  =  i-j;
                maxLen  =  Math.max(maxLen , len);
            } 
            
        }
         return maxLen;
        
        
    }
}
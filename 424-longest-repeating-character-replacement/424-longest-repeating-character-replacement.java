class Solution {
    public int characterReplacement(String s, int k) {
        int map[] =  new int[26];
        int i=0, j=0,maxCount=0, maxLen=0;
        while(i<s.length()){
            // acquire 
            map[s.charAt(i)-'A' ]++;
            maxCount =  Math.max(maxCount,map[s.charAt(i)-'A']);
            if( i-j+1 - maxCount >k  ){
                // release one char 
                map[s.charAt( j++)-'A' ]--;
            }
            
            maxLen =  Math.max(maxLen,i-j+1);
            i++;
            
        }
        return maxLen;
    }
}

// That is, we do not need the accurate max count of the current window; we only care if the max count exceeds the historical max count; and that can only happen because of the new char.
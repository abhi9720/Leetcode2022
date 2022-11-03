class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int freq[] =  new int[256];
        int idx = s.charAt(0), maxLen=1;
        freq[idx]++;
        int l = 0 , e = 1;
        while(e<s.length()){
            while(freq[s.charAt(e)]>0){
                freq[s.charAt(l)]--;
                l++;
            }
            freq[s.charAt(e)]++;
            int len  = e-l+1;
            maxLen =  Math.max(maxLen , len);
            e++;
        }
        return maxLen;
    }
}
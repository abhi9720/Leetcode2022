class Solution {

    public int longestSubstring(String s, int k) {
        int map[] = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        int ans = 0;
        int start = 0;
        boolean valid = true;
        for (int end = 0; end < s.length(); end++) {
            int idx = s.charAt(end) - 'a';
            if (map[idx] > 0 && map[idx] < k) {
                // this is point of split
                ans = Math.max(ans, longestSubstring(s.substring(start, end), k));
                valid = false;
                start =  end+1;
            }
            
        }
        if (valid) {
            return s.length();
        } else {
            return Math.max(ans, longestSubstring(s.substring(start), k));
        }
    }
}

class Solution {
    Map<String, Boolean> map;

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        map = new HashMap<>();
        return helper(s1, s2);
    }

    private boolean helper(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 1) {
            return s1.equals(s2);
        }
        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        String temp1 = new String(ch1);
        String temp2 = new String(ch2);

        if (!temp1.equals(temp2)) {
            return false;
        }

        String key = s1 + "," + s2;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int n = s1.length();
        // split in mcm pattern
        for (int i = 1; i < n; i++) {
            // Check if S2[0...i] is a scrambled
            // string of S1[0...i] and if S2[i+1...n]
            // is a scrambled string of S1[i+1...n]
            if (helper(s1.substring(0, i), s2.substring(0, i)) && helper(s1.substring(i, n), s2.substring(i, n))) {
                map.put(key, true);
                return true;
            }

            // Check if S2[0...i] is a scrambled
            // string of S1[n-i...n] and S2[i+1...n]
            // is a scramble string of S1[0...n-i-1]
            if (helper(s1.substring(n - i, n), s2.substring(0, i)) && helper(s1.substring(0, n - i), s2.substring(i, n))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}
/*

Apporach :
1. Split the string in possible length 
2. Check both path recursive 
*/

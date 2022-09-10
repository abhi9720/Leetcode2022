class Solution {
    HashMap<String, Boolean> dp;

    public boolean isScramble(String s1, String s2) {
        dp = new HashMap<>();
        return helper(s1, s2);
    }

    private boolean helper(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 != n2) return false;
        if (s1.equals(s2)) return true;
        String key = s1 + "," + s2;
        if (dp.containsKey(key)) return dp.get(key);

        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if (!(new String(ch1).equals(new String(ch2)))) return false;
        for (int i = 1; i < n1; i++) {
            // 1st with 1st and 2nd with second
            boolean ans1 = 
                
                helper(s1.substring(0, i), s2.substring(0, i)) 
                && helper(s1.substring(i), s2.substring(i));
            
            if (ans1) {
                dp.put(key, true);
                return true;
            }
            
            // 1st with 2nd part and 2nd part with 1st part
            boolean ans2 = 
                helper(s1.substring(0, i), s2.substring(n1 - i)) 
                && helper(s1.substring(i), s2.substring(0, n1 - i));

            if (ans2) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}

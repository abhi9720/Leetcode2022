class Solution {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        // int freq[] = new int[26];
        // for (String word : words2) {
        //     for (char ch : word.toCharArray()) {
        //         freq[ch - 'a']++;
        //     }
        // }
        
        // store what maximum character can be required in word 
        int[] freq = count("");
        for (String b: words2) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                freq[i] = Math.max(freq[i], bCount[i]);
        }
        
        

        List<String> ans = new ArrayList<>();
        for (String word : words1) {
            int f[] = new int[26];
            for (char ch : word.toCharArray()) {
                f[ch - 'a']++;
            }
            boolean val = isAllPresent(freq, f);

            if (val) {
                ans.add(word);
            }
        }
        return ans;
    }
    
     public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }

    private boolean isAllPresent(int f1[], int f2[]) {
        for (int i = 0; i < 26; i++) {
            if (f1[i]> f2[i]) return false;
        }
        return true;
    }
}

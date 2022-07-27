class Solution {

    public String greatestLetter(String s) {
        int freq[] = new int[26];
        int MOD = 10001;
        for (char ch : s.toCharArray()) {
            int idx = ch > 'Z' ? ch - 'a' : ch - 'A';
            // freq[idx] =  ch >'Z' ?  (freq[idx]/MOD +1)*MOD + freq[idx]%MOD +1
            //     : (freq[idx]/MOD )*MOD + freq[idx]%MOD +1 ;
            int small = freq[idx] % MOD;
            int large = freq[idx] / MOD;
            if (ch > 'Z') {
                large = large == 0 ? large + 1 : large;
            } else {
                // small =  small+1;
                small = small == 0 ? small + 1 : small;
            }
            freq[idx] = large * MOD + small;
        }

        for (int i = 25; i >= 0; i--) {
            if (freq[i] != 0) {
                int small = freq[i] % MOD;
                int large = freq[i] / MOD;
                if (small > 0 && large > 0) {
                    return (char) ('A' + i) + "";
                }
            }
        }
        return "";
    }
}

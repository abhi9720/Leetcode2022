/*
For example, say s="11010110", and k=3, and we just finish calculating the hash of the first substring: "110" (hash is 4+2=6, or 110). Now we want to know the next hash, which is the hash of "101".

We can start from the binary form of our hash, which is 110. First, we shift left, resulting 1100. We do not need the first digit, so it is a good idea to do 1100 & 111 = 100. The all-one 111 helps us to align the digits. Now we need to apply the lowest digit of "101", which is 1, to our hash, and by using |, we get 100 | last_digit = 100 | 1 = 101.

*/

class Solution {
    public static boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] got = new boolean[need];
        int allOne = need - 1;
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            // calculate hash for s.substr(i-k+1,i+1)
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');
            // hash only available when i-k+1 > 0
            if (i >= k - 1 && !got[hashVal]) {
                got[hashVal] = true;
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
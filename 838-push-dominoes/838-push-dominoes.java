class Solution {

    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        char arr[] = dominoes.toCharArray();
        int pi = 0;
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] == 'L') {
                if (arr[pi] == 'L') {                    
                    for (int x = pi; x <= i; x++) {
                        arr[x] = 'L';
                    }
                } else { // previopus is R there
                    int lo = pi + 1, hi = i - 1;
                    while (lo < hi) {
                        arr[lo] = 'R';
                        arr[hi] = 'L';
                        lo++;
                        hi--;
                    }
                }
                pi = i;
            } else if(arr[i]=='R') { // current is R
                if (arr[pi] == 'R') {
                    for (int x = pi; x < i; x++) {
                        arr[x] = 'R';
                    }
                } else {
                    // do nothing
                }
                pi = i;
            }
        }
        arr[0] = ' ';
        arr[arr.length - 1] = ' ';
        return new String(arr).trim();
    }
}

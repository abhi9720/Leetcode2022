class Solution {

    public int[] plusOne(int[] digits) {
        int c = 0, s = 0, n = digits.length;
        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            s = digits[i] + c + (i == n - 1 ? 1 : 0);
            c = s / 10;
            s = s % 10;
            ans[i] =  s;
        }
        if (c != 0) {
            int temp[] =  ans;
            ans=  new int[n+1];
            ans[0] =  c;
            System.arraycopy(temp,0,ans,1,n);
        }
        return ans;
    }
}

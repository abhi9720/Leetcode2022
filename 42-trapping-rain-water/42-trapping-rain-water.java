class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int lmax = height[0], rmax = height[n - 1];
        int water = 0;
        while (l < r) {
            if (height[r] > height[l]) {
                lmax =  Math.max(lmax, height[l]);
                water += lmax - height[l];
                l++;
            } else {
                rmax =  Math.max(rmax, height[r]);
                water += rmax - height[r];
                r--;
            }
        }

        return water;
    }
}

class Solution {
    public int maxArea(int[] height) {
        int i  =0  , j = height.length-1;
        int ans = 0;
        while(i<j){
            if(height[i] < height[j]){
                int val =  (j-i)*height[i];
                ans =  Math.max( ans , val );
                i++;
            }
            else{
                int val = (j-i)*height[j];
                ans =  Math.max( ans , val );
                j--;
            }
        }
        return ans;
    }
}
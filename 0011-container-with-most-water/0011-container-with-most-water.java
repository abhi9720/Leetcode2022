class Solution {
    public int maxArea(int[] height) {
        int i = 0 , j =  height.length-1;
        int max = 0;
        while(i<j){
            
            if(height[i] < height[j]){
                int water  =  height[i]*(j-i);
                i++;
                max  =  Math.max(max , water);
            }
            else{
                int water  =  height[j]*(j-i);
                j--;
                max  =  Math.max(max , water);                
            }                        
        }
        return max;
        
        
    }
}
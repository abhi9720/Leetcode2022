class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int mc =0, c=0;
        for(int ele : nums){
            if(ele==0){
                c = 0;
            }
            else{
                c++;                
            }
            mc =  Math.max(c,mc);
        }
        return mc;
    }
}
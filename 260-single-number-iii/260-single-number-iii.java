class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int ele : nums){
            xor ^=ele;
        }
        // now find one diff bit 
        int rsb = xor&-xor;// rsb 1 means diff by this bit, as odd
        // number of 1 xor is 1
        int x1 = 0,x2 = 0;
        for(int ele : nums){
            if((rsb&ele)!=0){
                x1 =  x1^ele;
            }
            else{
                x2 =  x2^ele;
            }
        }
        return new int[]{x1,x2};
    }
}
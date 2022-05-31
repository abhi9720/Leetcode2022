class Solution {
    public int singleNumber(int[] nums) {
        
        // count bits 
        // 0,1,2,3,4,5,6,7, ............. 31
        int num  =0;
        for(int i=0;i<32;i++){            
            int mask = (1<<i);
            int bitCount = 0;
            for(int ele :nums){
                bitCount+= ( (ele & mask) != 0 ?1:0  );
            }
            
            if(bitCount%3!=0){
                num = num | (1<<i);
            }
        }
        return num;
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len[] =  new int[nums.length];
        Arrays.fill(len,1);
        int maxLen = 1;
        
        for(int i=1;i<nums.length;i++){
            // move back in pre array 
            for(int j=i-1;j>=0;j--){
                if(nums[j] < nums[i] && len[j]+1 > len[i] ){
                    len[i] =  len[j]+1;
                }
            }
            maxLen =  Math.max(len[i],maxLen);
        }
        
        return maxLen;
    }
}
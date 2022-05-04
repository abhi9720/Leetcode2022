class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i =0  , j =  nums.length-1,count = 0;
        while(i<j){
            int sum =  nums[i]+nums[j];
            if(sum==k){
                i+=1;j-=1;
                count++;
            }else if(sum>k){
                j-=1;
            }
            else{
                i+=1;
            }
        }        
        return count;
    }
    
}
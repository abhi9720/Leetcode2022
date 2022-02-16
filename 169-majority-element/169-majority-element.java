class Solution {
    public int majorityElement(int[] nums) {
        int freq =1;
        int ele =  nums[0];
        for(int i=1;i<nums.length;i++){
            if(ele!=nums[i]){
                freq-=1;
            }
            else{
                freq+=1;
            }            
            if(freq==0){
                ele =  nums[i];
                freq=1;
            }
        }
        return ele;        
    }
}
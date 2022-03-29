class Solution {
    public int findDuplicate(int[] nums) {
        // without using extra space or modify data
        
        // find cycle
        int slow =  nums[0];
        int fast = nums[0];
        
        while(true){
            slow =  nums[slow];
            fast =  nums[nums[fast]];            
            
            if(slow==fast) break;
        }
        // reset slow
        slow =  nums[0];
        while(slow!=fast){
            slow =  nums[slow];
            fast =  nums[fast];
        }
        return  slow;
        
    }
}
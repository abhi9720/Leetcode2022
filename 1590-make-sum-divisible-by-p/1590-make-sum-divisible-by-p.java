class Solution {
    public int minSubarray(int[] nums, int p) {
        long s  =  0;
        for(int ele : nums){
            s+=ele;
        }        
        long target =  s%p;        
        if(target==0) return 0;
        
        
        Map<Long,Integer> map =  new HashMap<>();
        map.put(0l,-1);
        long sum = 0 ;
        int minLength =  nums.length;
        // now summing up 
        for(int i=0;i<nums.length;i++){
            sum =   ( sum+(nums[i])%p)%p;
            long key  =  (sum-target+p)%p;
            // -target beacuse we want subarray which gives remainder target
            // and + p to make negative value positive e.g 3 1, 4, 2 , p =  6
            
            if(map.containsKey(key)){
                int len =  i - map.get(key); // previous index this sum occured
                minLength =  Math.min(minLength,len);
            }
            map.put(sum , i);                        
        }
        return (minLength == nums.length?-1 : minLength);
        
        
        
    }
}
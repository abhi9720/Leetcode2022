class Solution {
    public int minSubarray(int[] nums, int p) {
        
        long s = 0;
        for(int ele :nums){
            s+=ele;
        }
        s =  s%p;
        if(s==0){
            return 0;
        }
        
        // find the subarrays such that its sum%p =  s
        HashMap<Long,Integer> map =  new HashMap<>();
        long sum = 0;
        map.put(sum,-1);
        int minLen =  nums.length;
        for(int i=0;i<nums.length;i++){
            sum = ( sum+(nums[i])%p)%p;
            long key = (sum-s+p)%p;
            if(map.containsKey(key) ){
                int len = i - map.get( key );
                minLen =  Math.min(minLen , len)  ;              
            }
                map.put(sum%p,i);
            
        }
        return (minLen == nums.length?-1:minLen);
        
    }
}
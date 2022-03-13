class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // sum , index last occur
        Map<Integer,Integer> map =  new HashMap<>();
        int sum  = 0;
        map.put(0,-1);
        
        //
        for(int i=0;i<nums.length;i++){
            sum = (sum+(( (nums[i]+k)%k +k)%k ))%k;
            if(map.containsKey(sum) ){
                // this sum occured previously
                int len =  i - map.get(sum);
                if(len>=2){
                    return true;
                }                                
            }else{
                map.put(sum,i);
            }
            
        }
        return false;
    }
}
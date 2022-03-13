class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer>map=  new HashMap<>();
        map.put(0,1);
        int sum=0,count=0;
        for(int ele : nums ){
            sum+=ele;
            if(map.get(sum-k) !=null ){
                count+=map.get(sum-k);
                
            }
            map.put(sum ,map.getOrDefault(sum,0)+1 );
        }
        return count;
    }
}
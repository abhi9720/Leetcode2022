class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0,sum=0;
        for(int ele : nums){
            sum =  (sum + ((ele+k)%k+k) %k ) %k;
            if(map.containsKey(sum) ){
                count+= map.get(sum );
                map.put(sum,map.get(sum)+1);
            }else{
                map.put( sum , 1 );
            }
        }
        return count;        
    }
}

// [7,-5,5,-8,-6,6,-4,7,-8,-7]
// 7
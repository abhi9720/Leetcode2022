class Solution {

    public long countPairs(int[] nums, int k) {
        

        HashMap<Integer, Integer> gcdMap = new HashMap<>();
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            long gcd_i =  gcd(nums[i] ,  k );
            for(var entry :  gcdMap.entrySet()){
                if(gcd_i*entry.getKey()%k==0) {
                	count+=entry.getValue();
                }
            }
            gcdMap.put((int)gcd_i ,gcdMap.getOrDefault((int)gcd_i, 0)+1  );
        }

        return count;
    }
    private int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
}
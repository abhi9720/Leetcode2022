/*


If (a*b)%k==0, then gcd(a,k) * gcd(b,k) % k is also 0.
prove : 
1. you can see this intuitively. When a number is divisible by another number, its prime factorization is a superset of the prime factorization of that number.

For example, 5544 (2 * 2 * 2 * 3 * 3 * 7 * 11) is divisible by 84 (2 * 2 * 3 * 7).

2. For example, GDC of 198 (2 * 3 * 3 * 11) and 84 (2 * 2 * 3 * 7) is 6 (2 * 3).
    With that, we can see that 
    
    gcd(n1, k) * gcd(n2, k)% k = n1 * n2 % k. 
    gcd =  maximum common factor 
   
    gcd(n1, k) - common between n1 and k
    gcd(n2, k) - and other left will be provided by n2 and k
    
    n1 * n2 % k = which is equal to n1*n2 % k
    
    

*/

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
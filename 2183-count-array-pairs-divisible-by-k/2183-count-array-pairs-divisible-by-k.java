/*



If (a*b)%k==0, then gcd(a,k) * gcd(b,k) % k is also divible by k
0.
prove : 
1. you can see this intutively. When a number is divisible by another number, its prime factorization is a superset of the prime factorization of that number.

For example, 5544 (2 * 2 * 2 * 3 * 3 * 7 * 11) is divisible by 84 (2 * 2 * 3 * 7).

2. For example, N1 = 198 (2 * 3 * 3 * 11) and N2 = 5544 (2 * 2 * 2 * 3 * 3 * 7 * 11)
    k =  42(2 * 3 * 7)
    gcd(198 , 42)  =  (2*3)
    gcd(5544 , 42) = (2 * 3 * 7 )
    => (2*3)*(2*3*7) =  2*2*3*3*7 superset of 42(2*3*7) so 42 divide it 
    
    198 (2 * 3 * 3 * 11) x 5544 (2 * 2 * 2 * 3 * 3 * 7 * 11) 
    => (2 * 3 * 3 * 11) * (2 * 2 * 2 * 3 * 3 * 7 * 11)  superset of 42(2*3*7) so 42 divide it 
    
    
    With that, we can see that 
    
    gcd(n1, k) * gcd(n2, k)% k = n1 * n2 % k. 
    gcd =  maximum common factor 

//---------------------------------------------------------------------------------------
   
    gcd(n1, k) - common between n1 and k
    gcd(n2, k) - and other left will be provided by n2 and k
    and gcd(n1, k) * gcd(n2, k) will have all prime factor of k 
    // so gcd(n1, k) * gcd(n2, k)%k==0
    
    n1 * n2 % k ==0 - The product of these 2 numbers will be divisible by a number k 
                    iff they must  contain atleast all the prime factors of k
    
    

*/

class Solution {

    public long countPairs(int[] nums, int k) {
        HashMap<Integer, Integer> gcdMap = new HashMap<>();
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            long gcd_i = gcd(nums[i], k);

            for (var entry : gcdMap.entrySet()) {
                if (gcd_i * entry.getKey() % k == 0) {
                    count += entry.getValue();
                }
            }
            gcdMap.put((int) gcd_i, gcdMap.getOrDefault((int) gcd_i, 0) + 1);
        }

        return count;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}

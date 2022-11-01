class Solution {

    public int countNicePairs(int[] nums) {
        long ans = 0;
        int mod =  (int)1e9+7;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - reverse(nums[i]);
            
            ans = (ans + map.getOrDefault(key, 0))%mod;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return (int)ans;
        
    }

    int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}

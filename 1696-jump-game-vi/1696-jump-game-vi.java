class Solution {
    public int maxResult(int[] nums, int k) {
        int n  =  nums.length;
        int dp[] =  new int[n];
        ArrayDeque<Integer> q =  new ArrayDeque<>();
        q.offer(0);
        dp[0] =  nums[0];
        for(int i=1;i<n;i++){
            if(q.peek()< i-k ) q.removeFirst();
            dp[i] = nums[i] +  dp[q.peek()];
            while( !q.isEmpty() &&  dp[i] >= dp[q.peekLast()]  ){
                q.removeLast();
            }
            q.offer(i);
        }
        return dp[n-1];
    }
}
class Solution {
    // time complexity :  nlogn + O(k) 
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        int sum = 0;
        for(int ele : nums){
            pq.offer(ele);
            sum+=ele;
        }
        while(k-->0){
            int peek  =  pq.remove();
            if(peek==0) break;
            sum+= -2*peek; 
            pq.offer(-peek);
        }
        return sum;
    }
}
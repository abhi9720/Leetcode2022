class KthLargest {

    PriorityQueue<Integer> q ;
    int k ;
    public KthLargest(int k, int[] nums) {
        this.k=  k;
        q =  new PriorityQueue<Integer>( );
        for(int ele : nums){
            q.offer(ele);
            if(q.size() > k ){
                q.poll();
            }
        }        
    }
    
    public int add(int val) {
        // need to do k-1 removal then kth element as kth largest
        q.offer(val);
        while(q.size()>k ){
            q.poll();
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
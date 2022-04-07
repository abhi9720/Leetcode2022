class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q =  new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones){
            q.offer(ele);
        }        
        while(q.size()>1 ){
            int h1 =  q.poll();
            int h2 =  q.poll();
            
            int newStone  = h1-h2;
            
            q.offer(newStone);
         
        }
        return   q.peek();
    }
}
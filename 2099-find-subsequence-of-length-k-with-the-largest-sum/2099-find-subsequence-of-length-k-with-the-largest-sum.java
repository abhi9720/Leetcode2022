class SortbyValue implements Comparator<int[]> {
 public int compare(int a[], int b[]){
        return a[0]-b[0];
    }
}

class SortbyIndex implements Comparator<int[]> {
 public int compare(int a[], int b[]){
        return a[1]-b[1];
    }
}

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // PriorityQueue<int[]> pq =  new PriorityQueue<>(new SortbyValue());
        PriorityQueue<int[]> pq =  new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
            if(pq.size() > k ){
                pq.poll();
            }
        }
        
        // PriorityQueue<int[]> p =  new PriorityQueue<>( new SortbyIndex());        
        PriorityQueue<int[]> p =  new PriorityQueue<>( (a,b)->a[1]-b[1]);        
        while(!pq.isEmpty() ){
            p.offer(pq.remove());
        }
        int seq[] =  new int[k];        
        for(int i=0;i<k;i++){            
            seq[i] = p.poll()[0];        
        }
        return seq;
    }
}
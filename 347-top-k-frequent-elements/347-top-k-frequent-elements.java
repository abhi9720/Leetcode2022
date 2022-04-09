class Solution {
   public class pair implements Comparable<pair>{
        int ele ;
        int freq;
        public pair(int ele , int freq){
            this.ele  =  ele;
            this.freq =  freq;            
        }
        @Override
        public int compareTo(pair p){
            return this.freq - p.freq;
        }
    }
    class pairComparator implements Comparator<pair>{
         public int compare(pair p1, pair p2) {
             return p1.freq - p2.freq;
         }
        
    }
    public int[] topKFrequent(int[] nums, int k) {
        
        
        HashMap<Integer,Integer> map =  new HashMap<>();
        for(int ele : nums){
            map.put( ele , map.getOrDefault(ele,0)+1 );
        }
        
        PriorityQueue<pair> q =  new PriorityQueue<>();
        for(int key : map.keySet() ){
            q.add( new pair(key, map.get(key) )  ) ;
            if(q.size() > k ){
                q.poll();
            }
        }
        int ans[] =  new int[k];
        int idx = 0;
        while(q.size()>0 ){
            ans[idx++] =  q.poll().ele;
        }
        return ans;
    }
}
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> map =  new HashMap<>();        
        
        for(int ele : barcodes){
            map.put(ele, map.getOrDefault(ele,0)+1 );
        }
        
        PriorityQueue<Integer> pq =  new PriorityQueue<>((a,b)-> map.get(b) -  map.get(a) );
        pq.addAll(map.keySet());
        int ans[] =  new int[barcodes.length];
        int itr =0;
        Integer prev =  null;
        while(!pq.isEmpty()){
            int curr =  pq.poll();
            ans[itr++] =  curr;
            map.put(curr , map.get(curr)-1);
            if(prev!=null){
                if(map.get(prev)>0)
                    pq.offer(prev);
            }
            prev =  curr;            
        }
        return ans;
    }
}
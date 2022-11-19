class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] =  new int[n];
        Arrays.fill(dist,-1);
        List<int[]> graph[] =  new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]  =  new ArrayList<>();
        }
        for(int i=0;i<times.length;i++){
            int src =  times[i][0]-1 , dest =  times[i][1]-1 , wt =  times[i][2];
            graph[src].add(new int[]{dest,wt});
            
        }
        
        PriorityQueue< int[] > pq =  new PriorityQueue<>( (a,b) -> b[1] -  a[1] );
        pq.offer(new int[]{k-1,0});
        while(pq.size()!=0){
            int rm[] =  pq.remove();
            int vtx =  rm[0];
            int time =  rm[1];
            if( dist[vtx]!=-1 && dist[vtx] < time    ){
                continue;
            }
            dist[vtx] =  time;
            for(int nbr[] : graph[vtx]){
                if( dist[nbr[0]] == -1 || dist[nbr[0]] > time + nbr[1] ){
                    pq.offer(new int[]{nbr[0] , time+nbr[1]});
                }
            }            
        }
        
        int max = 0;
        for(int ele : dist){
            if(ele==-1) return -1;
            max =  Math.max(max, ele);
        }
        return max;
        
        
    }
}
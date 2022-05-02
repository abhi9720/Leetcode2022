class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int []>[] graph = new ArrayList[n+1];
        
        for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
        
        
        for(int i =0;i<times.length;i++){
            int src =  times[i][0];
            graph[src].add( times[i] );
        }
        int time = 0;
        PriorityQueue<int []> q =new PriorityQueue<>( (o1,o2)-> o1[1] - o2[1] );
        boolean visited[] =  new boolean[n+1];
        q.add( new int[]{k,0});
        while(q.size()>0 ){
            int peek[] =  q.remove();
            if(visited[peek[0]] ) continue;
            time  =  Math.max(peek[1], time );
            visited[peek[0]] =  true;
            for(int []ed : graph[peek[0]]){
                if(!visited[ed[1]] ){ // src, nbr,time
                    q.offer(new int[]{ed[1],peek[1]+ed[2]});
                }
            }            
        }
        
        for(int i=1;i<=n;i++){
            if(visited[i]==false)return -1;
        }
        return time;
        
    }
}
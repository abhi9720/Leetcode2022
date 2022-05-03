class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    
        ArrayList<int[]> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] =  new ArrayList<>();            
        }
        for(int i=0;i<flights.length;i++){
            graph[flights[i][0]].add( flights[i] );
        }
        
        return dijkstra(n,graph,src,dst,k);
        
        
    }
    
    private int dijkstra(int n,ArrayList<int[]> graph[],int src,int dest, int k){

        PriorityQueue<int[]> q =  new PriorityQueue<>( (o1,o2)-> o1[1]- o2[1] );
        q.add(new int[]{src,0,0});// src,dest,count of nodes
        int depthTillNow[] =  new int[n];
        Arrays.fill(depthTillNow,-1);
        while( q.size() > 0 ){
            int peek[] =  q.remove();
            int node =  peek[0], cost =  peek[1] , depth = peek[2];
            
            if(node == dest) return cost;            
            if(depth>k)continue;
            if(depthTillNow[node]!=-1 && depthTillNow[node] < depth ) continue;
            depthTillNow[node] = depth ;
                                            
                for(int ed[] : graph[peek[0] ]){                
                    q.offer( new int[]{ed[1],ed[2]+peek[1],depth+1} );                     
                }    
            
        }
        return -1;                
    }
    
    
    
}
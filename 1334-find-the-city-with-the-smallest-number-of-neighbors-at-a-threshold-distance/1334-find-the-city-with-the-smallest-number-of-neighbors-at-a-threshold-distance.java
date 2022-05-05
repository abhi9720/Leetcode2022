// The Reason of DFS Not Working (Explain Graph and Example)
// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/490555/The-Reason-of-DFS-Not-Working-(Explain-Graph-and-Example)

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        ArrayList<int []>[]graph =  new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] =  new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){            
            int v1=  edges[i][0];
            int v2 =  edges[i][1];
            int wt =  edges[i][2];
            graph[v1 ].add(new int[]{v1,v2,wt});            
            graph[v2 ].add(new int[]{v2,v1,wt});            
            
        }
        int node = -1;
        int ans =  Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count = bfs(n,graph,i,distanceThreshold);            
            if(ans >=count){
                node =  i;
                ans =  count;                    
            }
        }
       
        return node;
        
    }
    
    
    private int bfs(int n , ArrayList<int []>[]graph, int src,int vo  ){
        Queue<int[]> q =  new ArrayDeque<>();
        int distTillNow[]= new int[n];        
        Arrays.fill(distTillNow,-1);
        
        q.add(new int[]{src,0});
        int count = 0;
        while(q.size() >0 ){
            int peek[] =  q.remove(); 
            int node =  peek[0] , dist = peek[1];   
            
            // if threshold crossed then continue , no reason to explore in this path
            if(dist > vo ) continue;
            
            // if this node previously visited !=-1, then only visit it again if we 
           //  visiting it in smaller distance
            
            if(distTillNow[node] != -1 && dist > distTillNow[node]    ) continue;
            
            
            // increase count only if first time visiting
            if(distTillNow[node] == -1){
                count++;
            }
            
            distTillNow[node] = dist;                                        
                                    
            for(int ed[]:graph[peek[0]]){
                // if threshold is not crossing the only push this neighbour
                if(dist+ed[2] <= vo) q.add(new int[]{ed[1],dist+ed[2]});                
            }                     
        }
        
        return count-1;
        
    }
}








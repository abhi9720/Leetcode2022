class Solution {
    // if there is no cycle in directed graph then there will be topological sort work
    // otherwise no order of compilation possible
    public boolean canFinish(int n, int[][] prerequisites) {
        // if there is cycle in graph then no answer possible 
        ArrayList<Integer>[] graph =  new ArrayList[n];
        for(int i=0;i<graph.length;i++){
            graph[i] =  new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int v1 =  prerequisites[i][0], v2 =  prerequisites[i][1];
            graph[v1].add( v2 );
        }        
        boolean visited[] =  new boolean[n];
        boolean dfsVisit[]= new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(isCycle(graph,visited,dfsVisit,i,-1)){
                    return false;
                }
            }
        }
        return true;        
    }
    
    // detect cycle in direct graph
    private boolean isCycle(ArrayList<Integer>[] graph, boolean visited[] , boolean dfsVisit[],int src, int parent){
        visited[src]  =  true;
        dfsVisit[src] =  true;
        
        // explore nbr
        for(int nbr : graph[src]){
            if(!visited[nbr] ){
                if(isCycle(graph,visited,dfsVisit,nbr,src)) return true;
            }
            else if(dfsVisit[nbr]){
                return true;
            }
        }
        
        dfsVisit[src] =  false;
        return false;
        
    }
    
}
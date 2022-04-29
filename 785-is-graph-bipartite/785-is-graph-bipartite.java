class pair{
    int v,l;
    public pair(int v,int l){
        this.v =  v;
        this.l  = l;
    }
    @Override
    public String toString(){
        return v+"@"+l+", ";
    }
}
 
class Solution {
    
    public boolean isBipartite(int[][] graph) {
        int n =  graph.length;
        int colors[] =  new int[n];
        for(int i=0;i<n;i++){
            if(colors[i]==0 && !dfs(graph,colors,1,i) ){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int [][]graph,int colors[],int color,int src){
        
        if(colors[src]!=0 ){
            return colors[src]==color;
        }
        
        colors[src]  =  color;
        for(int nbr:graph[src]){
            if(!dfs(graph,colors,-color,nbr)){
                return false;
            }
        }
        return true;
    }
  
    /*
//     bfs
    public boolean isBipartite(int[][] graph) {
        int n =  graph.length;
        Integer visited[]= new Integer[n];
        
        
        
        for(int i=0;i<n;i++){
            if(visited[i]==null && !isBipartite(graph,visited,i)){
                return false;
            }
        }
        return true;
    }
    
    boolean isBipartite(int [][]graph, Integer visited[], int src ){
        ArrayDeque<pair> q =  new ArrayDeque<>();
        q.add(new pair(src,1) );
        while(q.size() >0 ){
            pair rm = q.remove();
            if(visited[rm.v]!=null ){
                
                // means we are visiting same vertex again
                // check its level same or not
                int orginalLevel =  visited[rm.v];
                int newLevel = rm.l;
                
                if(orginalLevel!=newLevel) return false;
            }
            
            visited[rm.v] = rm.l;
            for(int nbr:graph[rm.v]){
                if(visited[nbr]==null)
                q.add(new pair(nbr,rm.l+1) );
            }   
            
        }
        return true;        
    }
    */
    
    
}
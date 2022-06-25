class Solution {
    
    public boolean isBipartite(int[][] graph) {
        int vtx =  graph.length;
        parent =    new int[vtx];
        rank =  new int[vtx];
        for(int i=0;i<parent.length;i++){
            parent[i]  = i;
        }
        
        for(int i=0;i<vtx;i++){
            for(int j=0;j<graph[i].length;j++){
                if(find(i) == find(graph[i][j]) ){                    
                    return false;
                }
                // else make use of this edge and connection them in union set
                // donot do union of i with graph[i][j]
                // as we nbr graph[i][j] check for its nbr and i will be parent in it 
                // and they have parent as we union them before and its return false 
                
                
                // union will call on lead of set
                union(find(graph[i][0]),find(graph[i][j]));
            }
        }
        return true;
    }
    
    int parent[] , rank[];
    
    private int find(int x){        
        if(x!=parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    
    // s1 and s2 lead 
    private void union(int s1L , int s2L){
        if(rank[s1L] < rank[s2L]){
            parent[s1L] =  s2L;
        }
        else if(rank[s2L] < rank[s1L]){
            parent[s2L] =  s1L;
        }
        else{
            parent[s1L] =  s2L;
            rank[s2L]++;
        }
        
        
    }
}
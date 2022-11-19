class Solution {
    int parent[] , rank[];
    
    public boolean isBipartite(int[][] graph) {
        int n  =  graph.length;
        parent  =  new int[n];
        rank =  new int[n];
        for(int i=0;i<n;i++){
            parent[i] =  i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                if(find(i)==find(graph[i][j])){
                    return false;
                }
                union(find(graph[i][0] ) , find(graph[i][j]) );
            }
        }
        return true;
    }
    
    public int find(int x){        
        if(parent[x]==x) return x;
        return parent[x] =  find(parent[x]);
    }
    
    public void union(int s1 , int s2){
        if(rank[s1]<=rank[s2]){
            rank[s2]++;
            parent[s1] =  s2;
        }
        else{
            rank[s1]++;
            parent[s2] =  s1;
        }
    }
    
    
    
}
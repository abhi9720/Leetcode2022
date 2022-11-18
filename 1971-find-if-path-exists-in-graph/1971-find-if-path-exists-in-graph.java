class Solution {
    static int parent[] , rank[] ;
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent =  new int[n];
        rank   =  new int[n];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        for(int ed[] : edges){
            int src =  ed[0];
            int dest =  ed[1];           
            union(find(src) , find(dest));
        }
        
        return find(source)==find(destination);
                
    }
    public static void union(int s1l , int s2l){
        if(rank[s1l] < rank[s2l]){
            parent[s1l] =  s2l;
        }
        else if(rank[s2l] < rank[s1l]){
            parent[s2l] =  s1l;
        }
        else{
            parent[s1l] = s2l;
            rank[s2l]++;
        }
            
    }
    public static int  find(int x){
        if(parent[x]==x) return x;
        return parent[x] =  find(parent[x]);
    }
}
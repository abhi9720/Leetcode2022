class Solution {

    public boolean isBipartite(int[][] graph) {
        int vtx = graph.length;
        
        
        Integer visited[] = new Integer[vtx];
        // bfs
        // for (int i = 0; i < vtx; i++) {
        //     if (visited[i] == null && bfs(graph, visited, i) == false) return false;
        // }        
        // return true;
        
        // dfs
        for(int i=0;i<vtx;i++){
            if(visited[i]==null && !dfs(graph,1,i,visited)) return false;            
        }
        return true;
    }

    
    private boolean dfs(int graph[][],int color ,int vtx, Integer visited[]){
        if(visited[vtx]!=null){
            return visited[vtx] == color;
        }
        visited[vtx] =  color;
        for(int nbr : graph[vtx]){
            if(!dfs(graph,-color,nbr,visited)) return false;
        }
        return true;
    }
    private boolean bfs(int graph[][],Integer visited[],int vtx) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] { vtx, 0 });
        while (q.size() > 0) {
            int peek[] = q.remove();
            if (visited[peek[0]] != null) {
                // if color not matches 
                if (visited[peek[0]] != peek[1]) return false;
                continue;
            }
            visited[peek[0]] = peek[1];
            for (int nbr : graph[peek[0]]) {                
                q.add(new int[] { nbr, (peek[1] + 1) % 2 });
                
            }
        }
        return true;
    }
}

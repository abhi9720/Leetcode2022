class Solution {

    public boolean isBipartite(int[][] graph) {
        int vtx = graph.length;
        
        
        Integer visited[] = new Integer[vtx];
        for (int i = 0; i < vtx; i++) {
            if (visited[i] == null && bfs(graph, visited, i) == false) return false;
        }

        

        return true;
    }

    private boolean bfs(int graph[][],Integer visited[],int vtx) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] { vtx, 0 });
        while (q.size() > 0) {
            int peek[] = q.remove();
            if (visited[peek[0]] != null) {
                if (visited[peek[0]] != peek[1]) return false;
                continue;
            }
            visited[peek[0]] = peek[1];
            // itertate over nbr            
            for (int nbr : graph[peek[0]]) {                
                q.add(new int[] { nbr, (peek[1] + 1) % 2 });
                
            }
        }
        return true;
    }
}

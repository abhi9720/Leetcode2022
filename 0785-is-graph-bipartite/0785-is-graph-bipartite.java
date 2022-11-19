class Solution {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int dist[] = new int[n];
        Arrays.fill(dist, -1);
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (dist[i] == -1) {
                q.offer(new int[] { i, 0 });
                while (q.size() != 0) {
                    int[] rm = q.poll();
                    if (dist[rm[0]] != -1 && dist[rm[0]] != rm[1]) {
                        return false;
                    }

                    dist[rm[0]] = rm[1];

                    for (int nbr : graph[rm[0]]) {
                        if (dist[nbr] == -1) q.offer(new int[] { nbr, rm[1] + 1 });
                    }
                }
            }
        }
        return true;
    }
}

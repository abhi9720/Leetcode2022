class Solution {

    HashMap<Integer, ArrayList<Integer>> graph;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // HashMap of all employyees
        // and queue to itetate over tree like structue
        graph = new HashMap<>();

        int time = 0;
        int src = 0;

        for (int i = 0; i < manager.length; i++) {
            int mid = manager[i];
            if (mid == -1) {
                src  = i;
                continue;
            }
            graph.putIfAbsent(mid, new ArrayList<>());
            graph.get(mid).add(i);
        }
        boolean visit[] =  new boolean[n];
        return dfs(visit,informTime,src);
       
    }
    private int dfs(boolean visit[] ,int[] time , int src ){
        visit[src] =  true;
        int t = 0;
        if(graph.containsKey(src) ){
            for(int nbr :  graph.get(src) ){
                if(!visit[nbr] ){
                    t =  Math.max(t ,time[src]+ dfs(visit,time,nbr));
                }                                
            }
        }
        return t;
    }
}

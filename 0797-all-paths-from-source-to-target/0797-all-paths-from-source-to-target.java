class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        boolean visited[] = new boolean[n];

        ArrayList<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(graph, path , ans,visited ,0 , n-1);
        return ans;
    }
    public static void helper(int graph[][] ,ArrayList<Integer> path ,List<List<Integer>> ans, boolean visited[], int src , int dest){
        
        if(src==dest){
            ArrayList<Integer> clone  =  new ArrayList<>(path);
            clone.add(dest);
            ans.add(clone);
            return ;
        }
        visited[src]  =  true;
        path.add(src);
        for(int nbr : graph[src]){
            if(!visited[nbr]){
                helper(graph,  path , ans,visited , nbr , dest );
            }
        }
        
         visited[src]  =  false;
        path.remove(path.size()-1);
    }
}

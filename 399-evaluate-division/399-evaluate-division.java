class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int q = queries.size();
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String v1 = equations.get(i).get(0);
            String v2 = equations.get(i).get(1);
            graph.putIfAbsent(v1, new HashMap<>());
            graph.putIfAbsent(v2, new HashMap<>());
            graph.get(v1).put(v2, values[i]);
            graph.get(v2).put(v1, 1.0 / values[i]);
        }

        double ans[] = new double[q];
        
        for (int i = 0; i < queries.size(); i++) {
            HashSet<String> visit = new HashSet<>();
            
            String v1 = queries.get(i).get(0);
            String v2 = queries.get(i).get(1);
            
            if(graph.containsKey(v1) && graph.containsKey(v2) ){
                ans[i] = dfs(v1,v2,graph,visit);
            }
            else{
                ans[i] =  -1.0;
            }
            
        }
        
        

        return ans;
    }

    private double dfs(String src, String dest, Map<String, Map<String, Double>> graph, HashSet<String> visit) {
        visit.add(src);
        if (src.equals(dest)) {
            return 1.0;
        }

        Map<String, Double> nbrs = graph.get(src);
        for (String nbr : nbrs.keySet()) {
            if (!visit.contains(nbr)) {
                double val = dfs(nbr, dest, graph, visit);
                if (val != -1.0) {
                    return val * nbrs.get(nbr);
                }
            }            
        }
        return -1.0;
    }
}

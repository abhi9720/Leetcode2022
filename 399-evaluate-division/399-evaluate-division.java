class Solution {
 private  Map<String, Map<String, Double>> makeGraph(List<List<String>> e, double[] values){
        // build a graph
        // like a -> b = values[i]
        // and b -> a  = 1.0 / values[i];
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u, v;
        
        for(int i = 0; i < e.size(); i++){
            u = e.get(i).get(0);
            v = e.get(i).get(1);
            
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1/values[i]);
            
        }
        return graph;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = makeGraph(equations, values);
        
        double []ans = new double[queries.size()];
        
        // check for every Querie
        // store it in ans array;
        for(int i = 0; i < queries.size(); i++){
            ans[i] = dfs(queries.get(i).get(0) , queries.get(i).get(1) , new HashSet<>(), graph);
        }
        return ans;
    }
    
    public double dfs(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph){
        // check the terminated Case
        // if string is not present in graph return -1.0;
        // like [a, e] or [x, x] :)
        if(graph.containsKey(src ) == false)
            return -1.0;
        
        // simply say check src and dest are equal :) then return dest 
        // store it in weight varaible;
        //case like [a,a] also handle
        if(graph.get(src).containsKey(dest)){
            return graph.get(src).get(dest);
        }
        
        visited.add(src);
        
        for(Map.Entry<String, Double> nbr : graph.get(src).entrySet()){
            if(visited.contains(nbr.getKey()) == false){
                double weight = dfs(nbr.getKey(), dest, visited, graph);
                
                // if weight is not -1.0(terminate case)
                // then mutliply it 
                // like in querie   a -> c => 2 * 3 = 6
                if(weight != -1.0){
                    return nbr.getValue() * weight;
                }
            }
        }
        return -1.0;
    }
}
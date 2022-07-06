class Solution {
    HashMap<String, PriorityQueue<String>> adj;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for(List<String> ticket: tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            if(adj.containsKey(src)){
                adj.get(src).add(dest);                
            } else {
                adj.put(src, new PriorityQueue<>());
                adj.get(src).add(dest);
            }
        }
        
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", res);
        return res;
    }
    
    public void dfs(String v, LinkedList<String> res){
        if(adj.containsKey(v) == false || adj.get(v).size() == 0){
            res.addFirst(v);
            return;
        }
        
        while(adj.get(v).size() > 0){
            String n = adj.get(v).remove();
            dfs(n, res);
        }
        
        res.addFirst(v);
    }
}
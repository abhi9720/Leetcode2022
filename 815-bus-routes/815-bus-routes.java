class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source==target) return 0;
        HashMap<Integer,ArrayList<Integer>> map =  new HashMap<>();
        
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                ArrayList<Integer> li =  map.getOrDefault(routes[i][j], new ArrayList<>()) ;
                li.add(i);
                map.put(routes[i][j],li);
            }
        }
        HashSet<Integer> visited  =  new HashSet<>();

        Queue<Integer> q =  new ArrayDeque<>();
        int count = 0;
        q.offer(source);
        while(q.size() >0){
            int len = q.size();
            count+=1;
            while(len-->0){
                int st  =  q.poll();
                // for this stations get all buses 
                ArrayList<Integer> buses =  map.get(st);
                for(int bus : buses){
                    if(visited.contains(bus) ) continue;
                    visited.add(bus);
                    // if this bus not used 
                    // then we can exlore all the station which can be visited by this bus 
                    for(int s : routes[bus]){ 
                        if(s== target ){
                            return count;
                        }
                        q.offer(s);
                    }
                }
            }
        }
        return -1;
            
        
    }
}
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> graph[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        
        int indegree[] =  new int[numCourses];   
        for (int edges[] : prerequisites) {
            int src = edges[0], dest = edges[1];
            graph[src].add(dest);
            indegree[dest]++;
        }
        
        Queue<Integer> q =  new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        
        int count  =  numCourses;
        while(!q.isEmpty()){
            int rm =  q.poll();
            
            for(int nbr : graph[rm]){
                if(--indegree[nbr]==0){
                    q.offer(nbr);
                }
            }  
            count--;
        }
        return count==0;
        
        
      
    }
}

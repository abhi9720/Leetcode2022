class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int visited[] =  new int[numCourses];
        
        List<Integer> graph[] =  new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i] =  new ArrayList<>();
        }
        for(int ed [] :  prerequisites){
            int src =  ed[0];
            int dest =  ed[1];
            graph[src].add(dest);            
        }
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0 && graph[i].size()!=0){
                if(!topoSort(graph,visited,i)) return false;
            }
        }
        return true;
    }
    public static boolean topoSort(List<Integer> graph[] , int visited[], int src){
        
        visited[src] =  2;
        for(int nbr : graph[src]){
            if(visited[nbr]==2) return false;
            else if(visited[nbr]==0){
                if(!topoSort(graph,visited,nbr)) return false;
            }
        }
        visited[src] =  1;        
        return true;
    }
}
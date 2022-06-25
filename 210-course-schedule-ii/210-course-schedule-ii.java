class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //prepare
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        int [] visited = new int[numCourses];
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(!topoSort(res, graph, visited, i)) return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = res.get(numCourses - i - 1);
        }
        return result;
    }

    private boolean topoSort(List<Integer> res, List<List<Integer>> graph, int [] visited, int i){
        int visit = visited[i];
        
        if(visit == 2){ // dependency of this vtx done , like its is again visited by some other component 
            // vtx
            return true;
        }
        if(visit == 1){  
            // means some of its nbr to nbr visit it again ,means all its  dependecy not resolved 
            // means cycle present 
            return false;
        }

        visited[i] =  1;
        for(int j : graph.get(i)){
            if(!topoSort(res, graph, visited, j)) return false;
        }
        visited[i] =  2;
        res.add(i);//the only difference with traversing a graph

        return true;
    }
}
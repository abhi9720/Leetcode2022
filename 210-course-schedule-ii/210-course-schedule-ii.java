class Solution {
    public int[] findOrder(int nc, int[][] prs) {
        
        ArrayList<Integer>[] graph =  new ArrayList[nc];
        for(int i=0;i<nc;i++){
            graph[i]=  new ArrayList<>();
        }
        int indeg[] =  new int[nc];
        for(int ed[] :prs ){
            int v1 =  ed[0], v2 =  ed[1];
            graph[v1].add(v2);
            indeg[v2]++;
        }
        Queue<Integer> q =  new ArrayDeque<>();
        for(int i=0;i<nc;i++){
            if( indeg[i] == 0 ) q.offer(i) ;
        }        
        int order[] = new int[nc];
        int i =  nc-1;
        while(q.size()!=0 ){
            int vtx =  q.poll();
            order[i--] =  vtx;
            for(int nbr : graph[vtx] ){
                indeg[nbr]--;
                if(indeg[nbr]==0) q.offer(nbr);
            }
        }
        if(i!=-1) return new int[0];
        return order;
    }
    
}
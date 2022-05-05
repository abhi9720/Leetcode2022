class Solution {
    
     class Edge{
        int v,nbr;
        double p;
       public Edge(int v, int nbr, double p) {
            this.v =  v;
            this.nbr =  nbr;
            this.p = p;
        }        
    }
    
     class mover implements Comparable<mover>{
        int v;
        double psf;
        mover(int v,double psf){
            this.v =  v;
            this.psf =  psf;
        }
        public int compareTo(mover o){
            return Double.compare( o.psf,this.psf);
        }
    }
    
    public  double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < edges.length; i++) {
            int v1 =  edges[i][0], v2 =  edges[i][1];
            double p =  succProb[i];
            graph[v1].add(new Edge(v1, v2, p));
            graph[v2].add(new Edge(v2, v1, p));            
        }
        
        return dijkstra(graph,n,start,end);

        
    }
    
    private  double dijkstra(ArrayList<Edge>[] graph,int vtces,int start,int end){
        
        PriorityQueue<mover> q =  new PriorityQueue<>();
        boolean visited[] =  new boolean[vtces];
        q.offer(new mover(start,1));
        while(q.size()>0 ) {
        	mover peek =  q.remove();
        	if(peek.v==end) return peek.psf;
        	if(visited[peek.v]) continue;
        	visited[peek.v] = true;
        	// now explore its neighbour
        	
        	for(Edge ed : graph[peek.v]) {
        		if(!visited[ed.nbr] ) {
        			q.offer(new mover(ed.nbr,peek.psf*ed.p) );
        		}
        	}        	        	
        }
        
        
        return 0.0d;
    }
    
}
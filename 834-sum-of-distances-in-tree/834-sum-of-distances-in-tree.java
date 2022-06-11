class Solution {
    int res[];
    int count[];
    List<Integer> [] graph;
    // consider it like a genric tree 
    //
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList[n];
        res =  new int[n];
        count  =  new int[n];
        for(int i=0;i<n;i++){
            graph[i] =  new ArrayList<>();
        }
        for(int e [] :edges){
            graph[e[0]].add( e[1] );
            graph[e[1]].add(e[0]);
        }
        
        
        postorder(0,-1); // -1 because , toogle parent-child calls not happend
        preorder(0,-1);
        // System.out.println(Arrays.toString(count) );
        return res;
    }
    
    private void postorder(int vtx , int parent){
        for(int nbr : graph[vtx] ){
            
            if(nbr==parent) continue;
            
            postorder(nbr,vtx);
            count[vtx]+=count[nbr];
            res[vtx]+=res[nbr]+count[nbr]; 
            // res[i]  sum of distance of nbr child(node) its substree
            // and doing +count[nbr] will increase distance by 1 
            // for all nodes as they it is distance from parent of it id child(node) 
        }
        count[vtx]++;        
    }
    private void preorder(int vtx, int parent){        
        int n =res.length;
        for(int nbr : graph[vtx]){
            if(nbr==parent) continue;
            res[nbr] = (res[vtx] - count[nbr]) + (n - count[nbr]);
            // nodes coming closer + nodes going farther 
            preorder(nbr,vtx);
        }        
    }
}
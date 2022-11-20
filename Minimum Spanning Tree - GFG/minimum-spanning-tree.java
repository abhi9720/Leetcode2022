//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    static class Edge{
        int u,v,wt;
        public Edge(int u, int v, int wt){
            this.u =  u;
            this.v =  v;
            this.wt =  wt;
        }
    }
    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] =  find(parent[x]);
    }
    
    static void union(int s1 , int s2){
        if(rank[s1]<= rank[s2]){
            parent[s1] =  s2;
            if(rank[s1]==rank[s2]) rank[s2]++;
        }
        else{
            parent[s2] = s1;
            rank[s1]++;
        }
    }
    
    static int parent[];
    static int rank[];
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        parent = new int[n];
        rank =  new int[n];
        for(int i=0;i<n;i++){
            parent[i] =  i;
        }
        ArrayList<int[]> edges =  new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<adj.get(i).size() ; j++ ){
                int u = adj.get(i).get(j).get(0);
                int v =  adj.get(i).get(j).get(1);
                edges.add(new int[]{i,u,v});
            }
        }
       int cost = 0;
       Collections.sort( edges , (a,b)-> a[2] - b[2] );
       for(int edge[] : edges){
           int u =  edge[0] , v =  edge[1] , wt =  edge[2];
           if(find(u)!= find(v)){
               cost+=wt;
               union(find(u), find(v));
           }
       }
        return cost;
        
    }
}





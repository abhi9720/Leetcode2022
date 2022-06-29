// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        
        boolean visited[] =  new boolean[V];
        int co = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,-1,-1,visited,i);
                co++;
            }
        }
        
        visited =  new boolean[V];
        int c1 = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,c,d,visited,i);
                c1++;
            }
        }
        
        return co==c1?0:1;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj,int c,int d , boolean visited[] ,int src
    ){
        visited[src] =  true;
        
        for(int nbr : adj.get(src) ){
            if((src==c && nbr==d) || (src==d && nbr==c) ) continue;
            if(!visited[nbr]){
                dfs(adj,c,d,visited,nbr);
            }
        }
    }
}
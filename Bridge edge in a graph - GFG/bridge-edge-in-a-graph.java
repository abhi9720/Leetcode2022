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
    static int res=0;
    static int time = 0;
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        
        res = 0;
        
       
       
        boolean visit[] =  new boolean[V];
        int discoverTime[] =  new int[V]; // discover time         
        int lowTime[] =  new int[V];
        boolean aps[] = new boolean[V];

        for(int i=0;i<V;i++){
            if(!visit[i]){
                dfs(adj,visit,discoverTime,lowTime,aps,i,-1,c,d);
            }
        }
       
       
       
        return res;
    }
     
    private static void dfs(ArrayList<ArrayList<Integer>> adj , boolean visit[] , int discoverTime[] , int lowTime[] ,
    boolean aps[], int u , int p , int c , int d ){
        visit[u]  =  true;
        discoverTime[u] =  lowTime[u] =  ++time;

        
        for(int v : adj.get(u) ){
            
            if(v==p){
                continue;
            }
            else if(visit[v]){
                // if already visited 
                lowTime[u]  =  Math.min(lowTime[u] , discoverTime[v]);
            }
            else{
                
                dfs(adj,visit,discoverTime,lowTime,aps,v,u,c,d);
                lowTime[u] =  Math.min(lowTime[u] , lowTime[v]);
                // below vextex 
                if(lowTime[v]  > discoverTime[u]  ){
                    if((v==c && u==d) || (v==d && u==c) ){
                        res =  1;
                    }
                }
            }
        }


    }
}
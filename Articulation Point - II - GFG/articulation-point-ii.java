// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visit[] =  new boolean[V];
        int discoverTime[] =  new int[V]; // discover time         
        int lowTime[] =  new int[V];
        boolean aps[] = new boolean[V];

        for(int i=0;i<V;i++){
            if(!visit[i]){
                dfs(adj,visit,discoverTime,lowTime,aps,i,-1);
            }
        }
        int size = 0;
        for(int i=0;i<V;i++){
            if(aps[i]) size++;
        }
        if(size==0) return new int[]{-1};
        int ans[] =  new int[size];
        
        int idx = 0;
        for(int i=0;i<V;i++){
            if(aps[i]){
                
                ans[idx++] =  i;
            }
        }
        return ans;
        
    }
    int time = 0;
    private void dfs(ArrayList<ArrayList<Integer>> adj , boolean visit[] , int discoverTime[] , int lowTime[] ,
    boolean aps[], int u , int p ){
        visit[u]  =  true;
        discoverTime[u] =  lowTime[u] =  ++time;

        int c  = 0;
        for(int v : adj.get(u) ){
            
            if(v==p){
                continue;
            }
            else if(visit[v]){
                // if already visited 
                lowTime[u]  =  Math.min(lowTime[u] , lowTime[v]);
            }
            else{
                c++;
                dfs(adj,visit,discoverTime,lowTime,aps,v,u);
                lowTime[u] =  Math.min(lowTime[u] , lowTime[v]);

                if(p==-1 && c>1){
                    aps[u]  =  true;
                }
                
                // means out nbr have reach below or equal to curr node u
                if(p!=-1 && lowTime[v]  >= discoverTime[u]  ){
                    aps[u] =  true;
                }
            }
        }


    }
}



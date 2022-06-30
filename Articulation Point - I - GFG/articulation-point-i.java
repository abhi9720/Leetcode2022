// { Driver Code Starts
// Initial Template for Java
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
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean visit[] =  new boolean[V];
        int discoveryTime[] =  new int[V];
        int lowTime[] =  new int[V];
        HashSet<Integer> arp =  new HashSet<>();
        for(int i=0;i<V;i++){
            if(!visit[i]){
                dfs(adj,visit,discoveryTime,lowTime,i,-1,arp);
            }
        }
        
        
        ArrayList<Integer> ans =  new ArrayList<>(arp);
        
        
        if(ans.size()==0 ) ans.add(-1);
        Collections.sort(ans);
        return ans;
        
    }
    int time = 0;
    private void dfs(ArrayList<ArrayList<Integer>> adj , boolean visit[] , int discoveryTime[],
    int lowTime[] , int src, int parent ,
    HashSet<Integer> arp
    ){
        
        lowTime[src] =  discoveryTime[src] = ++time;
        visit[src] =  true;
        
        // explore all its nbr
        int child = 0;
        for(int nbr :  adj.get(src) ){
            if(nbr==parent){
                continue;
            }
            else if( visit[nbr] ){
                lowTime[src]  =  Math.min(lowTime[src] , discoveryTime[nbr] );
            }
            else{
                child+=1;
                dfs(adj,visit,discoveryTime,lowTime , nbr ,  src,arp);
                lowTime[src] =  Math.min(lowTime[src] , lowTime[nbr] );
                
                if(parent==-1 && child>1){
                    arp.add(src);
                }
        
                if(parent!=-1 && discoveryTime[src] <= lowTime[nbr] ){
                    arp.add(src);
                }
            }
        }
         
        
        
        
        
    }
}
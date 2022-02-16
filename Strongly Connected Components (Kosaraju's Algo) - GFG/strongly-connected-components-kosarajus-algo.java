// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    public void topoSort(ArrayList<ArrayList<Integer>> graph , Stack<Integer>stk,boolean visited[], int src){
        visited[src] =  true;
        for(Integer ed: graph.get(src) ){
            if(!visited[ed]){
                topoSort(graph,stk,visited,ed);
            }
        }
        stk.push(src);
    }
    
    public void reverseDFS(int src ,ArrayList<ArrayList<Integer>> graph, boolean visited[] ){
        visited[src] =  true;
        for(Integer nbr : graph.get(src) ){
            if(!visited[nbr]){
                reverseDFS(nbr,graph,visited);
                
            }
        }
        
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stk =  new Stack<>();
        boolean visited[] =  new boolean[V];
        
        // step 1 done 
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topoSort(adj,stk,visited,i);
            }
        }
        
        // step 2  transpose graph
        ArrayList<ArrayList<Integer>> transpose =  new ArrayList<>();
        
        for(int i=0;i<V;i++){
            transpose.add(new ArrayList<Integer>() );
        }
        Arrays.fill(visited,false);
        for(int i=0;i<V;i++){
            for(Integer nbr :adj.get(i)){
                transpose.get(nbr).add(i);
            }
        }
            
        int count  = 0;
        // now do reverse dfs using stack
        while(!stk.empty() ){
            int node =  stk.pop();
            if(!visited[node]){
                reverseDFS(node,transpose,visited);
                count++;
            }
        }
            
            return count;
        
    }
}

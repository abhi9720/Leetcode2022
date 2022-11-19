//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        int visited[] =  new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==0  ){
                if(topoSort(adj, i , visited)) return true;
            }
        }
        return false;
    }
    boolean topoSort( ArrayList<ArrayList<Integer>> adj , int src , int visited[]){
        
        visited[src] =  2;
        for(int nbr : adj.get(src)){
            if(visited[nbr]==2) return true;
            else if(visited[nbr]==0) if(topoSort(adj , nbr , visited)) return true;
        }
        visited[src ] =  1;
        return false;
    }
}
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean visited[] =  new boolean[V];
        int count = 0;
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                dfs(adj,i,visited);
                count++;
            }
        }
        return count;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean visited[]){
        
        visited[src] =  true;
        for(int i=0; i< adj.get(src).size();i++ ){
            
            if( adj.get(src).get(i)!=0 && !visited[i] ){
                dfs(adj,i,visited);
            }
        }
    }
};
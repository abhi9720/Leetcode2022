// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} // } Driver Code Ends


// Your Output: 
// [[7, 2, 4, 6], [7, 8], [0, 5, 4], [4], [3, 0, 9, 2], [7, 2, 9], 
// [0, 7, 8], [0, 1, 5, 6], [1, 6], [4, 5]]
// 0


class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i] =  new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int v1 =  Edges.get(i).get(0);
            int v2 =  Edges.get(i).get(1);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        // System.out.println(Arrays.toString(graph) );
        boolean visited[] = new boolean[N+1];
        for(int i=1;i<=N;i++){
            if(!visited[i] && checkHamiltonPath(""+i,graph,visited,1,i)) return true;
        }
        return false;
        
    }
    boolean checkHamiltonPath(String psf,ArrayList<Integer>[] graph ,boolean visited[],int count ,int src){
        if(count==graph.length-1)
        {
            
            return true;
        }
        
        visited[src] =  true;
        // explore nbr
        for(int nbr :graph[src] ){
            if(!visited[nbr]){
             boolean f = checkHamiltonPath(psf+","+nbr,graph,visited,count+1,nbr);
             if(f) return true;
            }
        }
        visited[src] =  false;
        return false;
        
    }
    

} 


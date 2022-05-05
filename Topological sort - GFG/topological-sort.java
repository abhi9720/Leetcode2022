// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph) 
    {
        // System.out.println(graph);
        // boolean present[] =  new boolean[V];
        // for(int i=0;i<graph.size();i++ ){
        //     for(Integer vtx : graph.get(i) ){
        //         present[vtx] =  true;
        //     }
        //     if(graph.get(i).size()!=0 ){
        //         present[i] =  true;
        //     }
        // }
        // System.out.println(Arrays.toString(present) );
        boolean visited[] =  new boolean[V];
        Stack<Integer> stk =  new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                sort(graph,visited,stk,i);
        }
    }
    
    // System.out.println(stk);
    
    int arr[] = new int[stk.size()];
    for(int i=0;i<arr.length;i++){
        arr[i] =  stk.pop();
    }
    // System.out.println(Arrays.toString(arr) );
    return arr;
  
}
  static void sort(ArrayList<ArrayList<Integer>> graph,boolean visited[], Stack<Integer> stk, int src){
        
        
        visited[src] =  true;
        // explore nbr
        for(Integer nbr : graph.get(src)){
            if(!visited[nbr]){
                // System.out.println("next call : "+nbr);
                sort(graph,visited,stk,nbr);
            }
        }
        
        stk.add(src);
        
        
    }
}

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int vtcesColor[] =  new int[n];
        Arrays.fill(vtcesColor,-1);// -1 means no color 
        return dfs(graph,m,n,0,vtcesColor);
    }
    private  boolean dfs(boolean graph[][],int m, int n, int v,int vtcesColor[]){
        if(v==n){
            return true;
        }
        
        // for current vertex , give starting possible color 
        for(int c = 1;c<=m;c++){
            // if non of nbr have this color then only we can give this color 
            boolean cangive =  true;
            for(int i=0;i<n;i++){
                if(graph[v][i] ){
                 if(vtcesColor[i]==c) {
                     cangive =  false;
                     break;
                 }
                }
            }
            if(cangive){
                vtcesColor[v] = c;
                // make call to next node 
                if(dfs(graph,m,n,v+1,vtcesColor)) return true;
                vtcesColor[v] = -1;
            }
        }
        return false;
    }
}


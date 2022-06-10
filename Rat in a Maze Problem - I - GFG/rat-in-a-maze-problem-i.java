// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans =  new ArrayList<>();
        
        dfs(m,n,"",ans,0,0 );
        return ans;
    }
    static int dirs[][] =  {{-1,0},{0,1},{1,0},{0,-1}}; //LURD
    private static void dfs(int grid[][], int n , String s, ArrayList<String>ans, int i, int j){
        if(i<0 || j<0 || i>=n || j>=n || grid[i][j]==0) return ;
        
        if(i==n-1 && j==n-1){
            ans.add(s );
            return ;
        }
        
        grid[i][j] =  0;
        
        dfs(grid,n,s+"U",ans,i-1,j);
        dfs(grid,n,s+"D",ans,i+1,j);
        dfs(grid,n,s+"L",ans,i,j-1);
        dfs(grid,n,s+"R",ans,i,j+1);
        
        
        
        grid[i][j] =  1;
        
        
    }
    
    
    private static char getDir(int code){
        if(code==0) return 'L';
        else if(code==1) return 'R';
        else if(code==2) return 'D';
        else return 'D';
    }
    
    
}
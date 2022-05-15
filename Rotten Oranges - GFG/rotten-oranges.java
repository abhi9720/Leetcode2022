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
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
  
      public int orangesRotting(int[][] grid)
    {
        
        int n =  grid.length, m =  grid[0].length;
        boolean visited[][] =  new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]>pq =  new PriorityQueue<>( (o1,o2)-> o1[0] -  o2[0] );
        //size 3 time , coordinate(x,y) 
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2 ){
                    pq.add(new int[]{0,i,j});
                }
            }
        }
        int time = 0;
        int dir[][] =  { {0,-1},{0,1},{1,0},{-1,0} };
        while(!pq.isEmpty() ){
            int peek[] =  pq.remove();
            if(visited[peek[1]][peek[2]] ){
                continue;
            }
            visited[peek[1]][peek[2]] =  true;
            //explore nbr
            time= Math.max(peek[0],time);
            for(int d[]: dir){
                int nx =  peek[1]+d[0];
                int ny =  peek[2]+d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m&& grid[nx][ny]==1 && !visited[nx][ny] ){
                    pq.add(new int[]{peek[0]+1,nx,ny });
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++ ){
                if(grid[i][j]!=0){
                    if(!visited[i][j] ) return -1;
                }
            }
        }
        return time;
        
    }
}
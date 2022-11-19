//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
     public int helpaterp(int[][] hospital) {
        int n  =  hospital.length;
        int m  =  hospital[0].length;
        boolean visit[][] =  new boolean[n][m];
        Queue<int[]> q =  new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j =0  ; j<m;j++){
             if(hospital[i][j]==2)   {
                 q.offer(new int[]{i,j});
             }
            }
        }
        q.offer(null);
        int time =0 ;
        int dir[][] = {{-1,0} , {0,-1}, {1,0},{0,1}};
        while(!q.isEmpty()){
            int vtx[]  =  q.poll();
            if(vtx==null){
                if(q.size()!=0){
                    time++;
                    q.offer(null);
                }
                
                
                
                continue;
            }
            int i =  vtx[0];
            int j =  vtx[1];
            if(visit[i][j]){
                continue;
            }
            
            visit[i][j] =  true;
            // explore nbr 
            for(int d[] : dir){
                int nx = i+d[0];
                int ny =  j+ d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m && hospital[nx][ny]==1 && !visit[nx][ny]){
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        // travel matrix again 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && hospital[i][j] == 1 ){
                    return -1;
                }
            }
        }
        return time;
        
        
    }
}

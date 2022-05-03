class Solution {
    int dir[][] =  {{-1,0},{1,0},{0,1},{0,-1}};
    public int swimInWater(int[][] grid) {
        int n =  grid.length;
        PriorityQueue<int[]> q =  new PriorityQueue<>((o1,o2)->o1[2]-o2[2]  );
        boolean visited[][] =  new boolean[n][n];
        q.offer(new int[]{0,0,grid[0][0]});// x,y,time
        
        while(q.size()>0 ){
            int peek[] =  q.remove();
            int x =  peek[0],y =  peek[1],t = peek[2];
            if(visited[x][y]) continue;
            // System.out.println(x+" "+y+" @ "+t);
            if(x==n-1 && y==n-1){
                return t;
            }
            
            boolean moved=  false;
            for(int d[]:dir){
                int nx  =  x+d[0] , ny =  y+d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<n){
                    if(  !visited[nx][ny] ){
                        moved =  true;
                        q.offer(new int[]{nx,ny,Math.max(grid[nx][ny],t) });                        
                    }
                }                
            }
            if(moved==false){
                // System.out.println("Not Moved");
                q.offer(new int[]{x,y,t+1});
            }
            else{
                // System.out.println("Moved");
                visited[x][y]  =  true;
            }
            // System.out.println("pq size : "+q.size() );
                     
            
        }
        return -1;
    }
}
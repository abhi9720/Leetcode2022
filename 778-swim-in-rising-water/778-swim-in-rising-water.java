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
            if(x==n-1 && y==n-1){
                return t;
            }
            visited[x][y]  =  true;                        
            for(int d[]:dir){
                int nx  =  x+d[0] , ny =  y+d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] ){
                    
/* 
Always insert neighbour, don't wait to raise our level
we can only move through neighbour right?
two cases -  our level less than neighbour or neighbour level less than our level
in both cases, we have to wait for the same amount of time, so their level become equal
and neighbour level will be Max of both currentNode level and neighbour level, at least one of them has to
raise to the same level so the wait will be the max of both of their level.
 */
                        q.offer(new int[]{nx,ny,Math.max(grid[nx][ny],t) }); 
                    
                }                
            }                        
            
        }
        return -1;
    }
}
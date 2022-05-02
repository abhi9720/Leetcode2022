class Triplet implements Comparable<Triplet>{
    int x,  y,  t;
    public Triplet(int x,int y, int t){
        this.x =  x;
        this.y =  y;
        this.t = t ;
    }
    public int compareTo(Triplet o){
        return this.t - o.t;
    }         
    public String toString(){
        return "["+x+","+y+"@ "+t+"] ";
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        // bfs 
//        why bfs -  beacuse first all surrounding orange will be rotten before before child
//         means sibling orange rotten first before child , it move like 1 dist,2dist, 3dist orange in this manner orange will be rotten
        

        int n =  grid.length;
        int m =  grid[0].length;
        PriorityQueue<Triplet> pq =  new PriorityQueue<>();
        // insert rotten oranfe at t  =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    pq.offer(new Triplet( i,j,0 ) );
                }
            }
        }
        
        boolean visited[][] =  new boolean[n][m];
        int dir[][]  = {{-1,0},{0,1},{0,-1},{1,0}};
        int time = 0;
        while(pq.size() >0 ){
            Triplet  p =  pq.remove();   
            
            if( visited[p.x][p.y] ) continue;            
            visited[p.x][p.y] =  true;
            time =  Math.max(time,p.t);
            for(int d[]:dir){
                int nx =  p.x+d[0];
                int ny =  p.y+d[1];
                if(isValid(n,m,nx,ny) && visited[nx][ny]== false && grid[nx][ny]==1 ){
                    pq.offer( new Triplet( nx,ny,p.t+1 )   );                    
                }
            }
            
        }      
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 ){
                    if(visited[i][j]==false ) return -1;
                }
            }
        }
        return time;
    }
    
    private boolean isValid(int n , int m,int newx,int newy){
        return newx>=0 && newy>=0 && newx<n && newy<m;
    }
    
    
}
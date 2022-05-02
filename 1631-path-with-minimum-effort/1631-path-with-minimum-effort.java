class Solution {
    static int dir[][]  = {{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        int n  =  heights.length, m =  heights[0].length;
        PriorityQueue<int []> q =  new PriorityQueue<>( (o1,o2)-> o1[2] - o2[2] );
        q.offer( new int[]{0,0,0} );// x,y,diff
        boolean visited[][]  =  new boolean[n][m];
        while(q.size() >0 ){
            int peek[] =  q.remove();
            
            if(peek[0]==n-1 && peek[1]==m-1 ) return peek[2];
            if( visited[ peek[0] ][peek[1]] ) continue;
            visited[ peek[0] ][peek[1]]  =  true;
            for(int d[] : dir ){
                int nx = peek[0]+d[0];
                int ny =  peek[1]+d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] ){
                    int absDiff =  Math.abs(heights[nx][ny] -  heights[peek[0] ][peek[1]]);
                    q.offer( new int[]{nx,ny,Math.max( peek[2], absDiff ) } );
                }
            }
            
        }
        return -1;
        
    }
}
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int n =  mat.length;
        int m  =  mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]==0){
                    q.offer(new int[] { i, j });
                }
            }
        }
        
        int ans[][] = new int[mat.length][mat[0].length];
        boolean visited[][] = new boolean[mat.length][mat[0].length];
        int time = 0;
        int dirs[][] =  {{-1,0},{1,0},{0,-1},{0,1}};
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int peek[] = q.poll();
                int x = peek[0], y = peek[1];
                if (visited[x][y]) continue;
                visited[x][y] = true;
                ans[x][y] =  time;
                
                // get its all nbr which are one 
                for(int d[] : dirs){
                    int nx = d[0]+x , ny =  d[1]+y;
                    if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny]  && mat[nx][ny]==1){
                        // System.out.println("add nbr : "+nx+" :  "+ny);
                        q.offer(new int[]{nx,ny});
                    }
                }
                
            }
            time++;
        }
        return ans;
    }
}

class Solution {
    
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        
        int lip[][] =  new int[n][m];
        for(int row[] : lip){
            Arrays.fill(row,-1);
        }
        // lip[i][j] -  longest increasing path starting from i,j
        int  max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(lip[i][j] ==-1 ){
                    max = Math.max(max,dfs(matrix,lip,i,j));
                }
            }
        }      
        return max;
    }

    
    int dir[][] =  {{-1,0},{1,0},{0,1},{0,-1}};
    private int dfs(int [][]matrix ,int lip[][] , int i,int j){
        int n = matrix.length , m = matrix[0].length;
        
        if(lip[i][j]!=-1 ){
            return lip[i][j];
        }
        int maxlen = 0;
        for(int d[] :dir){
            int nx =  i+d[0] , ny =  j+d[1];
            if(nx >=0 && ny>=0 && nx<n && ny<m && matrix[i][j] < matrix[nx][ny] ){
                maxlen =  Math.max(maxlen , dfs(matrix,lip,nx,ny));
            }
        }
        
        return lip[i][j] =  maxlen+1;
        
    }
}









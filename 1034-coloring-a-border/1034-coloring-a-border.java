class Solution {
    public class Pair{
        int i;
        int j;
        boolean border;
        
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        ArrayDeque<Pair> q=new ArrayDeque<>();
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        ArrayList<Pair> al=new ArrayList<>();
        
        Pair p=new Pair(row,col);
        p.border=isBorder(grid,row,col);
        q.add(p);
        int oclr=grid[row][col];
        while(q.size()>0){
            Pair rem=q.remove();
            if(visited[rem.i][rem.j]) continue;
            visited[rem.i][rem.j]=true;
            
            al.add(rem);
            
           addNbr(rem.i+1,rem.j,grid,visited,q,oclr);
           addNbr(rem.i-1,rem.j,grid,visited,q,oclr);
           addNbr(rem.i,rem.j+1,grid,visited,q,oclr);
           addNbr(rem.i,rem.j-1,grid,visited,q,oclr);
        }
        
        for(Pair pp:al){
            if(pp.border==true){
                grid[pp.i][pp.j]=color;
            }
        }
        return grid;
    }
    
    void addNbr(int i,int j,int[][] grid,boolean[][] visited,ArrayDeque<Pair> q,int oclr){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=oclr || visited[i][j]==true)
            return;
        Pair np=new Pair(i,j);
        np.border=isBorder(grid,i,j);
        q.add(np);
    }
    
    public boolean isBorder(int[][] grid,int i,int j){
        if(i==0){
            return true;
        }
        else if(j==0){
            return true;
        }
        else if(i==grid.length-1)
            return true;
        else if(j==grid[0].length-1)
            return true;
        else {
            int color=grid[i][j];
            if(grid[i+1][j]!=color)
                return true;
            else if(grid[i][j+1]!=color)
                return true;
            else if(grid[i-1][j]!=color)
                return true;
            else if(grid[i][j-1]!=color)
                return true;
            else
                return false;
        }
        
    }
}
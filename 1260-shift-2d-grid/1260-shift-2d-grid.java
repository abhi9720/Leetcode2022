class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n =  grid.length,m =  grid[0].length;
        int size =  m*n;

        k =  k%size;
        int loop = size, i =(size-k)%size ;
        List<List<Integer>> ans=  new ArrayList<>();
        int count = 0;
        List<Integer> li =  new ArrayList<>();
         while(loop-->0){ 
             int x =  i/m , y = i%m;
             li.add( grid[x][y] );
             count++;
             if(count==m){
                 ans.add(li);
                 li =  new ArrayList<>();                 
                 count = 0;
             }
             i =  (i+1)%size;                 
         }                                                
        return ans;
    }
}
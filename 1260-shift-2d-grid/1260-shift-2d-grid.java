class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n =  grid.length,m =  grid[0].length;
        int size =  m*n;
//         while(k-->0){
            
//             int loop = size, i =0; 
//             int prev =  grid[0][0];
//             while(loop-->0){                
//                 int x =  i/m , j = i%m;
//                 int x1 =   ((i+1)%size)/m, y1   =  ((i+1)%size)%m;
//                 int currNext =  grid[x1][y1];
//                 grid[x1][y1] =  prev;
//                 prev =  currNext;
//                 i++;                                
//             }            
//         }
        
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
        
        
        
        
        
        System.out.println( ans  );
        
        return ans;
    }
}